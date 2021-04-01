package tn.cni.injez.controller;


import java.util.Date;
import java.util.List;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tn.cni.injez.response.Response;
import tn.cni.injez.model.Utilisateur;
import tn.cni.injez.model.UtilisateurProfilProjet;
import tn.cni.injez.model.AutreFinancement;
import tn.cni.injez.model.Profil;
import tn.cni.injez.model.Projet;
import tn.cni.injez.repository.UtilisateurRepository;
import tn.cni.injez.service.UtilisateurService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthentificationController {
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired  
	ServletContext context;

	
	@PostMapping("/loginUser")
	public int LoginUser(@RequestBody Utilisateur user ) {
    return utilisateurService.LoginUser(user);
    }
	
	@PostMapping("/loginAdmin")
	public int LoginAdmin(@RequestBody Utilisateur admin ) {
    return utilisateurService.LoginAdmin(admin);
    }
	
	@PostMapping("/loginAdminCni")
	public int LoginAdminCni(@RequestBody Utilisateur admin_cni ) {
    return utilisateurService.LoginAdminCni(admin_cni);
    }
   
	
	
	
	@GetMapping("/loggedOut")
	public void Logout() {
     utilisateurService.Logout();
	}
	
	
	@PostMapping("/ajouterUtilisateur")
	public ResponseEntity<Response> ajouterUtilisateur (@RequestParam("file") MultipartFile file,
			@RequestParam("user") String utilisateur) throws JsonParseException , JsonMappingException , Exception {
		 System.out.println("Ok .............");
	        Utilisateur user = new ObjectMapper().readValue(utilisateur, Utilisateur.class);
	        boolean isExit = new File(context.getRealPath("/Images/")).exists();
	        if (!isExit)
	        {
	        	new File (context.getRealPath("/Images/")).mkdir();
	        	System.out.println("mk dir.............");
	        }
	        String filename = file.getOriginalFilename();
	        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
	        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
	        try
	        {
	        	System.out.println("Image");
	        	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
	        	 
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }

	       
	        user.setFileName(newFileName);
	        Utilisateur art = utilisateurRepository.save(user);
	        if (art != null)
	        {
	        	return new ResponseEntity<Response>(new Response (""),HttpStatus.OK);
	        }
	        else
	        {
	        	return new ResponseEntity<Response>(new Response ("User not saved"),HttpStatus.BAD_REQUEST);	
	        }
     
    }
	
	@GetMapping("/afficherUtilisateurs")
	public ResponseEntity<Response> afficherUtilisateurs() {
		return ResponseEntity.status(HttpStatus.OK).body(new Response(utilisateurService.afficherUtilisateurs(), new Date()));
	}
	
	@PostMapping("/modifierUtilisateur")
    public Utilisateur modifierUtilisateur(@RequestBody Utilisateur user) {
		return utilisateurService.modifierUtilisateur(user);
    }
	
	
	@DeleteMapping("/supprimerUtilisateur")
	public HttpStatus supprimerUtilisateur(@RequestParam("username") String username) {
			return utilisateurService.supprimerUtilisateur(username);
		
	}
	
	@GetMapping("/rechercherUtilisateur/{recherche}")
    public List<Utilisateur> searchUtilisateur (@PathVariable(value="recherche") String recherche){
    	return utilisateurService.searchUtilisateur(recherche);
    }
	
	@GetMapping("/utilisateurCourant")
	public ResponseEntity<Response> utilisateurCourant() {
		return ResponseEntity.status(HttpStatus.OK).body(new Response(utilisateurService.utilisateurCourant(), new Date()));
		
	}
	
	
	@GetMapping(path="/Imgarticles/{username}")
	 public byte[] getPhoto(@PathVariable("username") String username) throws Exception{
		
		 Utilisateur user   = utilisateurRepository.findById(username).get();
		 return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+user.getFileName()));
	 }
	
	
	@GetMapping("/projetsProfilsParUtilisateur")
	public List<UtilisateurProfilProjet> usersProfilsParUtilisateur(){
		return utilisateurService.findProjectsAndProfilesOfUser();	}
	
	
	@GetMapping("/afficherProfil/{project}")
	public Profil afficherProfil(@PathVariable(value="project") String project) {
      return utilisateurService.profilCourant(project);
	}

}