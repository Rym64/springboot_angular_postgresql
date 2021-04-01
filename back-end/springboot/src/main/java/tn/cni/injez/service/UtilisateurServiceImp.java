package tn.cni.injez.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.cni.injez.exception.ResourceNotFoundException;
import tn.cni.injez.model.Gouvernorat;
import tn.cni.injez.model.Profil;
import tn.cni.injez.model.Projet;
import tn.cni.injez.model.Role;
import tn.cni.injez.response.Response;
import tn.cni.injez.model.Utilisateur;
import tn.cni.injez.model.UtilisateurProfilProjet;
import tn.cni.injez.repository.UtilisateurProfilProjetRepository;
import tn.cni.injez.repository.UtilisateurRepository;

@Service
public class UtilisateurServiceImp implements UtilisateurService {
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	UtilisateurProfilProjetRepository utilisateurProfilProjetRepository;
	@Autowired
	ProjetService projetService;
	
	Profil profil1 = null;
	
	
	@Override
	public int LoginUser(Utilisateur user) {
		 
		List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
		for (Utilisateur utilisateur : utilisateurs) {
			if ((utilisateur.getUsername()).equals(user.getUsername())
					&& (utilisateur.getPassword()).equals(user.getPassword())) {
				if (utilisateur.getRole()==Role.مستخدم) {
				user=utilisateur;
				user.setLogged(1);
				this.supprimerUtilisateur(utilisateur.getUsername());
				utilisateurRepository.save(user);
				return 0;}
				else return 2;
				}
			 
		  }
		return 1;
		}
	
	
	@Override
	public int LoginAdmin(Utilisateur admin) {
		 
		List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
		for (Utilisateur utilisateur : utilisateurs) {
			if ((utilisateur.getUsername()).equals(admin.getUsername())
					&& (utilisateur.getPassword()).equals(admin.getPassword())) {
				if (utilisateur.getRole()==Role.مُشْرِف) {
				admin=utilisateur;
				admin.setLogged(1);
				this.supprimerUtilisateur(utilisateur.getUsername());
				utilisateurRepository.save(admin);
				return 0;}
				else return 2;
				}
			 
		  }
		return 1;
		}
	
	
	@Override
	public int LoginAdminCni(Utilisateur adminCni) {
		 
		List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
		for (Utilisateur utilisateur : utilisateurs) {
			if ((utilisateur.getUsername()).equals(adminCni.getUsername())
					&& (utilisateur.getPassword()).equals(adminCni.getPassword())) {
				if (utilisateur.getRole()==Role.مُشْرِف_بالمركز_الوطني_للإعلامية) {
				adminCni=utilisateur;
				adminCni.setLogged(1);
				this.supprimerUtilisateur(utilisateur.getUsername());
				utilisateurRepository.save(adminCni);
				return 0;}
				else return 2;
				}
			 
		  }
		return 1;
		}
		
	
	
	
	
	
	
	
	

	@Override
	public void Logout() {
	 utilisateurRepository.logout();
	}

	@Override
	public Utilisateur ajouterUtilisateur(Utilisateur user) {
		Calendar c = Calendar.getInstance();
		
		if(user.getDate_naissance()!=null) {
            c.setTime(user.getDate_naissance());
			
			c.add(Calendar.DATE, 1);
			java.sql.Date dateNaissance1= new java.sql.Date(c.getTimeInMillis());
			user.setDate_naissance(dateNaissance1);}
		
		this.setAdresseUser(user);
		return utilisateurRepository.save(user);

	}

	@Override
	public List<Utilisateur> afficherUtilisateurs() {
		return this.findUtilisateusByEtablissement();
		
	}
	
	public List<Utilisateur> findUtilisateusByEtablissement() {
		List<Utilisateur> liste = this.utilisateurCourant();
		Iterator iter = liste.iterator();
		Utilisateur user = (Utilisateur) iter.next();
		List<Utilisateur> listUtilisateurs = utilisateurRepository.findAll(); 
		List<Utilisateur> listUtilisateurs1 = new ArrayList<>();
		listUtilisateurs.forEach(utilisateur -> {
			if ((utilisateur.getEtablissement())==user.getEtablissement()) {
				listUtilisateurs1.add(utilisateur);
			}
			
		}); 
		return listUtilisateurs1;
		}
	
	
	
	
	@Override
	public List<UtilisateurProfilProjet> findProjectsAndProfilesOfUser(){
		List<Utilisateur> liste = this.utilisateurCourant();
		Iterator iter = liste.iterator();
		Utilisateur user = (Utilisateur) iter.next();
		List<UtilisateurProfilProjet> listProjets = utilisateurProfilProjetRepository.findAll(); 
		List<UtilisateurProfilProjet> listProjets1 = new ArrayList<>();
		listProjets.forEach(projetProfilUser -> {
			if ((projetProfilUser.getUser().getEtablissement())==user.getEtablissement()) {
				listProjets1.add(projetProfilUser);
			}
			
		}); 
		Collections.sort(listProjets1, (UtilisateurProfilProjet o1, UtilisateurProfilProjet o2) -> {
				int c;
				c = o1.getUser().getUsername().compareTo(o2.getUser().getUsername());
				if (c == 0)
					c = o1.getProfil().getType_profil().compareTo(o2.getProfil().getType_profil());
				return c;}
		);
		
		return listProjets1;
		
		}
	
	
	
	@Override
	public Utilisateur modifierUtilisateur(Utilisateur user) {
		Calendar c = Calendar.getInstance();

		if (user != null) {
			if(user.getDate_naissance()!=null) {
	            c.setTime(user.getDate_naissance());
				
				c.add(Calendar.DATE, 1);
				java.sql.Date dateNaissance1= new java.sql.Date(c.getTimeInMillis());
				user.setDate_naissance(dateNaissance1);}
			
			this.setAdresseUser(user);
			return utilisateurRepository.save(user);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}
		
		
		
	}

	@Override
	public HttpStatus supprimerUtilisateur(String username) {
		if (username != null) {
			utilisateurRepository.deleteById(username);
			HttpStatus responseDelete = HttpStatus.OK;
			return responseDelete;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + username);
		}
	}

	@Override
	public List<Utilisateur> utilisateurCourant() {
		List<Utilisateur> listUsers = utilisateurRepository.findAll();
		List<Utilisateur> listUsers1 = new ArrayList<>();
		listUsers.forEach(user -> {
			if ((user.getLogged()) == 1)
				listUsers1.add(user);
		}); 
		return listUsers1;
	}
	
	
	@Override
	public List<Utilisateur> searchUtilisateur(String recherche)
	{List<Utilisateur> listUtilisateurs = this.findUtilisateusByEtablissement();
	List<Utilisateur> listUtilisateurs1 = new ArrayList<>();
	Set<Utilisateur> setUtilisateurs = new LinkedHashSet<>();

	listUtilisateurs.forEach(user ->{
    	if ((user.getUsername())!=null) {if ((user.getUsername()).equals(recherche)) {setUtilisateurs.add(user);} }
    	if ((user.getName())!=null) {if ((user.getName()).equals(recherche)) {setUtilisateurs.add(user);} }
    	if ((user.getLast_name())!=null) {if ((user.getLast_name()).equals(recherche)) {setUtilisateurs.add(user);} }
    	if ((user.getEmail())!=null) {if ((user.getEmail()).equals(recherche)) {setUtilisateurs.add(user);} }
    	if ((user.getSexe())!=null) {if ((user.getSexe()).toString().equals(recherche)) {setUtilisateurs.add(user);} }
    	if ((user.getAdresse())!=null) {if ((user.getAdresse()).toString().equals(recherche)) {setUtilisateurs.add(user);} }
    	if ((user.getDate_naissance())!=null) {if ((user.getDate_naissance()).toString().equals(recherche)) {setUtilisateurs.add(user);} }
    	if ((user.getRole())!=null) {if ((user.getRole()).toString().equals(recherche)) {setUtilisateurs.add(user);} }

	} ); 
	setUtilisateurs.forEach(user9 -> {listUtilisateurs1.add(user9);});

	return listUtilisateurs1;}
	
	
	   public void setAdresseUser(Utilisateur user)
	   {
		   if (user.getAdresse()==Gouvernorat.أريانة) {user.setAdresse_geocoordinate("36.862499, 10.195556");}   
	       else if (user.getAdresse()==Gouvernorat.باجة) {user.setAdresse_geocoordinate("36.72564, 9.18169");}
	       else if (user.getAdresse()==Gouvernorat.بن_عروس) {user.setAdresse_geocoordinate("36.75306, 10.21889");} 
	       else if (user.getAdresse()==Gouvernorat.بنزرت) {user.setAdresse_geocoordinate("37.27442, 9.87391");}
	       else if (user.getAdresse()==Gouvernorat.قابس) {user.setAdresse_geocoordinate("33.88146, 10.0982");}
	       else if (user.getAdresse()==Gouvernorat.قفصة) {user.setAdresse_geocoordinate("34.431141, 8.775656");}
	       else if (user.getAdresse()==Gouvernorat.جندوبة) {user.setAdresse_geocoordinate("36.50114, 8.78024");}
	       else if (user.getAdresse()==Gouvernorat.القيروان) {user.setAdresse_geocoordinate("35.6781, 10.09633");	}	
	       else if (user.getAdresse()==Gouvernorat.القصرين) {user.setAdresse_geocoordinate("35.16758, 8.83651");	}
	       else if (user.getAdresse()==Gouvernorat.قبلي) {user.setAdresse_geocoordinate("33.70439, 8.96903");}	
	       else if (user.getAdresse()==Gouvernorat.الكاف) {user.setAdresse_geocoordinate("36.17424, 8.70486");}	
	       else if (user.getAdresse()==Gouvernorat.المهدية) {user.setAdresse_geocoordinate("35.506798, 11.046753");}
	       else if (user.getAdresse()==Gouvernorat.منوبة) {user.setAdresse_geocoordinate("36.80803, 10.09721");}
	       else if (user.getAdresse()==Gouvernorat.مدنين) {user.setAdresse_geocoordinate("33.35495, 10.50548");}
	       else if (user.getAdresse()==Gouvernorat.المنستير) {user.setAdresse_geocoordinate("35.77799, 10.82617");}
	       else if (user.getAdresse()==Gouvernorat.نابل) {user.setAdresse_geocoordinate("36.45606, 10.73763");}
	       else if (user.getAdresse()==Gouvernorat.صفاقس) {user.setAdresse_geocoordinate("34.74056, 10.76028");}
	       else if (user.getAdresse()==Gouvernorat.سيدي_بوزيد) {user.setAdresse_geocoordinate("35.03823, 9.48494");}
	       else if (user.getAdresse()==Gouvernorat.سليانة) {user.setAdresse_geocoordinate("36.08497, 9.37082");}
	       else if (user.getAdresse()==Gouvernorat.سوسة) {user.setAdresse_geocoordinate("35.821430, 10.634422");}
	       else if (user.getAdresse()==Gouvernorat.تطاوين) {user.setAdresse_geocoordinate("32.92967, 10.45177");}
	       else if (user.getAdresse()==Gouvernorat.توزر) {user.setAdresse_geocoordinate("33.91968, 8.13352");}
	       else if (user.getAdresse()==Gouvernorat.تونس) {user.setAdresse_geocoordinate("36.806389, 10.181667");}
	       else if (user.getAdresse()==Gouvernorat.زغوان) {user.setAdresse_geocoordinate("36.40291, 10.14292");}
	   }
	   
	   
	   @Override
		public Profil profilCourant(String project)
		{
		   List<Utilisateur> liste = this.utilisateurCourant();
		Iterator iter = liste.iterator();
		Utilisateur user = (Utilisateur) iter.next();
		List<UtilisateurProfilProjet> listUsersProfilsProjets = utilisateurProfilProjetRepository.findAll(); 
		listUsersProfilsProjets.forEach(userProfilProjet -> {if (((userProfilProjet.getUser())==user)&&(userProfilProjet.getProjet().getCode().equals(project))) {this.profil1 = userProfilProjet.getProfil();}});
        return this.profil1;
}
}
