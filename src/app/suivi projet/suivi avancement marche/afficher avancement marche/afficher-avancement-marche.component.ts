import { Component, OnInit, TemplateRef } from '@angular/core';
import { Decomposition } from '../../../shared/modele/decomposition.model';
import { Projet } from '../../../shared/modele/projet.model';
import { FormGroup } from '@angular/forms';
import { WebService } from '../../../shared/sevices/web.service';
import { Router } from '@angular/router';
import { User } from '../../../shared/modele/user.model';
import pdfMake from 'pdfmake/build/pdfmake';
import { MatDialog} from '@angular/material/dialog';
import pdfFonts from 'pdfmake/build/vfs_fonts';
import { ModifierUtilisateurComponent } from 'src/app/authentification/modifier utilisateur/modifier-utilisateur.component';
pdfMake.vfs = pdfFonts.pdfMake.vfs;


@Component({
  selector: 'app-afficher-avancement-marche',
  templateUrl: './afficher-avancement-marche.component.html',
  styleUrls: ['./afficher-avancement-marche.component.css']
})


export class AfficherAvancementMarcheComponent implements OnInit {

  
  ngOnInit(): void {
    this.getData();
    this.getCurrentUser();
  }



  decompositionsList: Array<Decomposition>
  decomposition: Decomposition = undefined
  decomposition1: Decomposition = new Decomposition();
  myForm: FormGroup;
  submitted = false;
  recherche:string;
  usersList: Array<User>
  user: User 
  listeProjet2: Array<Projet>


  constructor(public dialog: MatDialog,private webService: WebService,private router: Router) { }



  getData(): void {
    this.webService.get("afficherDecompositions").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.decompositionsList = response.data }) 
  }



  rechercherAvancementMarche(recherche){
    this.router.navigate(['rechercherAvancementMarche', recherche]);  
  }



  downloadPdf(){

  }



  getCurrentUser(): void {
    this.webService.get("utilisateurCourant").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.usersList = response.data})
  }


  updateUserCurrent(user){  
    this.webService.setterUser(user);
    this.dialog.open(ModifierUtilisateurComponent, {
      height: '700px',
      width: '500px',});
  }



   loggedOut(){
     this.webService.loggedOut("loggedOut")
     .subscribe(data => console.log(data), error => console.log(error));
   window.location.href="/login";}


   afficherUtilisateurs()
   {this.router.navigate(['/afficherUtilisateurs']);
    window.location.href="/afficherUtilisateurs";}
   
   
   
   afficherUserProfilProjet()
   {this.router.navigate(['/afficherUserProfilProjet']);
    window.location.href="/afficherUserProfilProjet";}

    

   afficherProjets(){
   this.router.navigate(['/afficherProjets']);
   window.location.href="/afficherProjets";}




   afficherFinancements(templateRef1: TemplateRef<any>,templateRef2: TemplateRef<any>){ 
    this.webService.get("projetCurrent").subscribe(listeProjets => {
      let listeProjet1 = JSON.parse(JSON.stringify(listeProjets))
      this.listeProjet2 = listeProjet1
    if (this.listeProjet2.length==0){this.dialog.open(templateRef1, {
      height: '170px',
      width: '400px',
    });}
    else {
     this.webService.getProfil("afficherProfil",this.listeProjet2[0].code).subscribe(theProfile => {let userProfile=theProfile
      if ((userProfile.type_profil == 'جميع الصلاحيات')||(userProfile.type_profil == 'تمويل')) { 
      this.router.navigate(['/afficherFinancements']);
      window.location.href = "/afficherFinancements";
    }
      else {this.dialog.open(templateRef2, {
        height: '170px',
        width: '550px',
      });} })}})
    }
  



   afficherDecompositions(templateRef1: TemplateRef<any>,templateRef2: TemplateRef<any>){ 
    this.webService.get("projetCurrent").subscribe(listeProjets => {
      let listeProjet1 = JSON.parse(JSON.stringify(listeProjets))
      this.listeProjet2 = listeProjet1
    if (this.listeProjet2.length==0){this.dialog.open(templateRef1, {
      height: '170px',
      width: '400px',
    });}
    else {
     this.webService.getProfil("afficherProfil",this.listeProjet2[0].code).subscribe(theProfile => {let userProfile=theProfile
    if ((userProfile.type_profil == 'جميع الصلاحيات')||(userProfile.type_profil == 'تقسيم')) { 
      this.router.navigate(['/afficherDecompositions']);
      window.location.href = "/afficherDecompositions";
    }
      else {this.dialog.open(templateRef2, {
        height: '170px',
        width: '550px',
      });} })}})
    }



  
   afficherAppelsOffre(templateRef1: TemplateRef<any>,templateRef2: TemplateRef<any>){ 
    this.webService.get("projetCurrent").subscribe(listeProjets => {
      let listeProjet1 = JSON.parse(JSON.stringify(listeProjets))
      this.listeProjet2 = listeProjet1
    if (this.listeProjet2.length==0){this.dialog.open(templateRef1, {
      height: '170px',
      width: '400px',
    });}
    else {
     this.webService.getProfil("afficherProfil",this.listeProjet2[0].code).subscribe(theProfile => {let userProfile=theProfile
      if ((userProfile.type_profil == 'جميع الصلاحيات')||(userProfile.type_profil == 'طلبات العروض و صفقات و فواتير')) { 
      this.router.navigate(['/afficherAppelsOffre']);
      window.location.href = "/afficherAppelsOffre";
    }
      else {this.dialog.open(templateRef2, {
        height: '170px',
        width: '550px',
      });} })}})
    }
  




   afficherAvancementMarche(templateRef1: TemplateRef<any>,templateRef2: TemplateRef<any>){ 
    this.webService.get("projetCurrent").subscribe(listeProjets => {
      let listeProjet1 = JSON.parse(JSON.stringify(listeProjets))
      this.listeProjet2 = listeProjet1
    if (this.listeProjet2.length==0){this.dialog.open(templateRef1, {
      height: '170px',
      width: '400px',
    });}
    else {
     this.webService.getProfil("afficherProfil",this.listeProjet2[0].code).subscribe(theProfile => {let userProfile=theProfile
      if ((userProfile.type_profil == 'جميع الصلاحيات')||(userProfile.type_profil == 'تقسيم')) { 
      this.router.navigate(['/afficherAvancementMarche']);
      window.location.href = "/afficherAvancementMarche";
    }
      else {this.dialog.open(templateRef2, {
        height: '170px',
        width: '550px',
      });} })}})
    }
  




    afficherObjectifs(templateRef1: TemplateRef<any>,templateRef2: TemplateRef<any>){ 
      this.webService.get("projetCurrent").subscribe(listeProjets => {
        let listeProjet1 = JSON.parse(JSON.stringify(listeProjets))
        this.listeProjet2 = listeProjet1
      if (this.listeProjet2.length==0){this.dialog.open(templateRef1, {
        height: '170px',
        width: '400px',
      });}
      else {
       this.webService.getProfil("afficherProfil",this.listeProjet2[0].code).subscribe(theProfile => {let userProfile=theProfile
        if ((userProfile.type_profil == 'جميع الصلاحيات')||(userProfile.type_profil == 'أهداف ومؤشرات')) { 
        this.router.navigate(['/afficherObjectifs']);
        window.location.href = "/afficherObjectifs";
      }
        else {this.dialog.open(templateRef2, {
          height: '170px',
          width: '550px',
        });} })}})
      }

      

}
