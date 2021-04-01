import { Component, OnInit, TemplateRef } from '@angular/core';
import { Projet } from '../../../shared/modele/projet.model';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { WebService } from '../../../shared/sevices/web.service';


@Component({
  selector: 'app-afficher-details-projet',
  templateUrl: './afficher-details-projet.component.html',
  styleUrls: ['./afficher-details-projet.component.css']
})


export class AfficherDetailsProjetComponent implements OnInit {

  
  private projet:Projet;
  listeProjet2: Array<Projet>


  constructor(public dialog: MatDialog,private webService:WebService,private router:Router) { }


  ngOnInit() {
    this.projet=this.webService.getterProjet();
  }



  afficherUtilisateurs()
{this.router.navigate(['/afficherUtilisateurs']);
 window.location.href="/afficherUtilisateurs";}



afficherUserProfilProjet()
{this.router.navigate(['/afficherUserProfilProjet']);
 window.location.href="/afficherUserProfilProjet";}

  afficherProjets()
   {this.router.navigate(['/afficherProjets']);
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
 



  afficherAvancementMarche(templateRef1: TemplateRef<any>,templateRef2: TemplateRef<any>) { 
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
