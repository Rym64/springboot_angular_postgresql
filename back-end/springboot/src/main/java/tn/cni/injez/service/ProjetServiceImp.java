package tn.cni.injez.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.injez.exception.ResourceNotFoundException;
import tn.cni.injez.model.Projet;
import tn.cni.injez.model.Role;
import tn.cni.injez.model.Utilisateur;
import tn.cni.injez.model.Gouvernorat;
import tn.cni.injez.model.Profil;
import tn.cni.injez.model.UtilisateurProfilProjet;
import tn.cni.injez.repository.ProjetRepository;
import tn.cni.injez.repository.UtilisateurProfilProjetRepository;

import org.springframework.data.domain.Sort;
import java.sql.Date;
import java.util.Calendar;


@Service
public class ProjetServiceImp implements ProjetService {
	@Autowired
	private UtilisateurProfilProjetRepository utilisateurProfilProjetRepository;
	@Autowired
	private ProjetRepository projetRepository;
	@Autowired
	private UtilisateurService utilisateurService;

	@Override
	public List<Projet> afficherProjets() {
		return this.findProjectsByUsername();
	}

	public List<Projet> findProjectsByUsername() {
		List<Utilisateur> liste = utilisateurService.utilisateurCourant();
		Iterator iter = liste.iterator();
		Utilisateur user = (Utilisateur) iter.next();
		List<UtilisateurProfilProjet> listProjets = utilisateurProfilProjetRepository.findAll(); 
		List<Projet> listProjets1 = new ArrayList<>();
		if (user.getRole()==Role.مستخدم) {	
		listProjets.forEach(projet -> {if ((projet.getUser())==user) {listProjets1.add(projet.getProjet());}});}
		else if (user.getRole()==Role.مُشْرِف)
		{listProjets.forEach(projet -> {if ((projet.getUser().getEtablissement())==user.getEtablissement()) {listProjets1.add(projet.getProjet());}});}
		
		return listProjets1;
		}
	
	 
	  
	@Override
	public Projet findByCode(String code) {
		 Projet projet=projetRepository.findByCode(code);
		 return projet;
		}
	@Override
	public Projet ajouterProjet(Projet projet) {
		List<Utilisateur> liste = utilisateurService.utilisateurCourant();
		Iterator iter = liste.iterator();
		Utilisateur user = (Utilisateur) iter.next();
		Calendar c1 = Calendar.getInstance();
		Calendar c3 = Calendar.getInstance();
		Calendar c5 = Calendar.getInstance();
		
		
		if (projet != null) {
			
			if(projet.getDate_debut()!=null) {
			c1.setTime(projet.getDate_debut());
			
			c1.add(Calendar.DATE, 1);
			java.sql.Date dateDebut1= new java.sql.Date(c1.getTimeInMillis());
			projet.setDate_debut(dateDebut1);}
			
		
			if(projet.getDate_fin()!=null) {
			c3.setTime(projet.getDate_fin());
			c3.add(Calendar.DATE, 1);
			java.sql.Date dateFin1= new java.sql.Date(c3.getTimeInMillis());
			projet.setDate_fin(dateFin1);}
			
			
			
			if(projet.getDate_financement_public()!=null) {
				c5.setTime(projet.getDate_financement_public());
				
				c5.add(Calendar.DATE, 1);
				java.sql.Date dateFinancement1= new java.sql.Date(c5.getTimeInMillis());
				projet.setDate_financement_public(dateFinancement1);}
			
			
			     this.setLieuProjet(projet);  
		
			
			UtilisateurProfilProjet p = new UtilisateurProfilProjet(user,null,projet);
			utilisateurProfilProjetRepository.save(p);
			
			return projetRepository.save(projet);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}
	
	@Override
	public Projet modifierProjet(Projet projet) {
		
		
		Calendar c2 = Calendar.getInstance();
		Calendar c4 = Calendar.getInstance();
		Calendar c5 = Calendar.getInstance();
		Calendar c9 = Calendar.getInstance();
		
		if (projet != null) {
           
			if (projet.getDate_debut_actualisee()!=null) {
			c2.setTime(projet.getDate_debut_actualisee());
			c2.add(Calendar.DATE, 1);
			java.sql.Date dateDebutActualise1= new java.sql.Date(c2.getTimeInMillis());
			projet.setDate_debut_actualisee(dateDebutActualise1);
			}
			
		
			if(projet.getDate_fin_actualisee()!=null){ 
			
			c4.setTime(projet.getDate_fin_actualisee());
			c4.add(Calendar.DATE, 1);
			java.sql.Date dateFinActualise1= new java.sql.Date(c4.getTimeInMillis());
			projet.setDate_fin_actualisee(dateFinActualise1);
			}
			
			if(projet.getDate_financement_public()!=null) {
				c5.setTime(projet.getDate_financement_public());
				
				c5.add(Calendar.DATE, 1);
				java.sql.Date dateFinancement1= new java.sql.Date(c5.getTimeInMillis());
				projet.setDate_financement_public(dateFinancement1);}
			
			
			if(projet.getDate_actualisation_financement_public()!=null) {
				c9.setTime(projet.getDate_actualisation_financement_public());
				
				c9.add(Calendar.DATE, 1);
				java.sql.Date dateActualisationFinancement1= new java.sql.Date(c9.getTimeInMillis());
				projet.setDate_actualisation_financement_public(dateActualisationFinancement1);}
			 this.setLieuProjet(projet);  
			return projetRepository.save(projet);
		} else {
			throw new ResourceNotFoundException("Record cannot be created");
		}

	}

	@Override
	public void supprimerProjet(String code) {
		if (code != null) {
			projetRepository.deleteByCode(code);
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + code);
		}

	}
	
	@Override
	public List<Projet> projetCourant() {
		List<Projet> listProjets = projetRepository.findAll();
		List<Projet> listProjets1 = new ArrayList<>();
		listProjets.forEach(projet -> {
			if ((projet.getCurrent()) == 1)
				listProjets1.add(projet);
		}); 
		return listProjets1;
	}
	
	@Override
	public List<Projet> searchProjet(String recherche)
	{List<Projet> listProjets = this.findProjectsByUsername();
	List<Projet> listProjets1 = new ArrayList<>() ;
	Set<Projet> setProjets = new LinkedHashSet<>();
	
	listProjets.forEach(projet ->{
		if (projet.getLibelle()!=null) {if((projet.getLibelle()).equals(recherche)) {setProjets.add(projet);}}
		if (projet.getDescription()!=null) {if((projet.getDescription()).equals(recherche)) {setProjets.add(projet);}}
		if ((projet.getDate_fin_actualisee())!=null) {if((projet.getDate_fin_actualisee()).toString().equals(recherche)) {setProjets.add(projet);}}
		if ((projet.getDate_debut_actualisee())!=null) {if((projet.getDate_debut_actualisee()).toString().equals(recherche)) {setProjets.add(projet);}}
		if ((projet.getCout_actualise())!=null) {if((projet.getCout_actualise()).toString().equals(recherche)) {setProjets.add(projet);}}
		if ((projet.getCode())!=null) {if((projet.getCode()).equals(recherche)) {setProjets.add(projet);}}
		if ((projet.getDate_fin())!=null) {if((projet.getDate_fin()).toString().equals(recherche)) {setProjets.add(projet);}}
		if ((projet.getDate_debut())!=null) {if((projet.getDate_debut()).toString().equals(recherche)) {setProjets.add(projet);}}
		if ((projet.getLieu_projet())!=null) {if((projet.getLieu_projet()).toString().equals(recherche)) {setProjets.add(projet);}}
		if ((projet.getCout())!=null) {if((projet.getCout()).toString().equals(recherche)) {setProjets.add(projet);}}
		if ((projet.getStade())!=null) {if((projet.getStade()).toString().equals(recherche)) {setProjets.add(projet);}}
		if ((projet.getFlag())!=null) {if((projet.getFlag()).toString().equals(recherche)) {setProjets.add(projet);}}
		if ((projet.getSecteur())!=null) {if((projet.getSecteur().getType_secteur()).toString().equals(recherche)) {setProjets.add(projet);}}

		
	} ); 
	
	setProjets.forEach(projet2 -> {
		listProjets1.add(projet2);
	});
	
	return listProjets1;}

   
   public void setLieuProjet(Projet projet)
   {
	   if (projet.getLieu_projet()==Gouvernorat.أريانة) {projet.setLieu_geocoordinate("36.862499, 10.195556");}   
       else if (projet.getLieu_projet()==Gouvernorat.باجة) {projet.setLieu_geocoordinate("36.72564, 9.18169");}
       else if (projet.getLieu_projet()==Gouvernorat.بن_عروس) {projet.setLieu_geocoordinate("36.75306, 10.21889");} 
       else if (projet.getLieu_projet()==Gouvernorat.بنزرت) {projet.setLieu_geocoordinate("37.27442, 9.87391");}
       else if (projet.getLieu_projet()==Gouvernorat.قابس) {projet.setLieu_geocoordinate("33.88146, 10.0982");}
       else if (projet.getLieu_projet()==Gouvernorat.قفصة) {projet.setLieu_geocoordinate("34.431141, 8.775656");}
       else if (projet.getLieu_projet()==Gouvernorat.جندوبة) {projet.setLieu_geocoordinate("36.50114, 8.78024");}
       else if (projet.getLieu_projet()==Gouvernorat.القيروان) {projet.setLieu_geocoordinate("35.6781, 10.09633");	}	
       else if (projet.getLieu_projet()==Gouvernorat.القصرين) {projet.setLieu_geocoordinate("35.16758, 8.83651");	}
       else if (projet.getLieu_projet()==Gouvernorat.قبلي) {projet.setLieu_geocoordinate("33.70439, 8.96903");}	
       else if (projet.getLieu_projet()==Gouvernorat.الكاف) {projet.setLieu_geocoordinate("36.17424, 8.70486");}	
       else if (projet.getLieu_projet()==Gouvernorat.المهدية) {projet.setLieu_geocoordinate("35.506798, 11.046753");}
       else if (projet.getLieu_projet()==Gouvernorat.منوبة) {projet.setLieu_geocoordinate("36.80803, 10.09721");}
       else if (projet.getLieu_projet()==Gouvernorat.مدنين) {projet.setLieu_geocoordinate("33.35495, 10.50548");}
       else if (projet.getLieu_projet()==Gouvernorat.المنستير) {projet.setLieu_geocoordinate("35.77799, 10.82617");}
       else if (projet.getLieu_projet()==Gouvernorat.نابل) {projet.setLieu_geocoordinate("36.45606, 10.73763");}
       else if (projet.getLieu_projet()==Gouvernorat.صفاقس) {projet.setLieu_geocoordinate("34.74056, 10.76028");}
       else if (projet.getLieu_projet()==Gouvernorat.سيدي_بوزيد) {projet.setLieu_geocoordinate("35.03823, 9.48494");}
       else if (projet.getLieu_projet()==Gouvernorat.سليانة) {projet.setLieu_geocoordinate("36.08497, 9.37082");}
       else if (projet.getLieu_projet()==Gouvernorat.سوسة) {projet.setLieu_geocoordinate("35.821430, 10.634422");}
       else if (projet.getLieu_projet()==Gouvernorat.تطاوين) {projet.setLieu_geocoordinate("32.92967, 10.45177");}
       else if (projet.getLieu_projet()==Gouvernorat.توزر) {projet.setLieu_geocoordinate("33.91968, 8.13352");}
       else if (projet.getLieu_projet()==Gouvernorat.تونس) {projet.setLieu_geocoordinate("36.806389, 10.181667");}
       else if (projet.getLieu_projet()==Gouvernorat.زغوان) {projet.setLieu_geocoordinate("36.40291, 10.14292");}
   }
	
}

	


	

