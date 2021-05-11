import { Component, OnInit, TemplateRef } from '@angular/core';
import { AppelOffre } from '../../../../shared/modele/appelOffre.model';
import { Projet } from '../../../../shared/modele/projet.model';
import { FormGroup} from '@angular/forms';
import { WebService } from '../../../../shared/sevices/web.service';
import { ModifierAppelOffreComponent } from '../modifier appel offre/modifier-appel-offre.component';
import { Router } from '@angular/router';
import { SupprimerAppelOffreComponent } from '../supprimer appel offre/supprimer-appel-offre.component';
import { DetailsAppelOffreComponent } from '../details appel offre/details-appel-offre.component';
import { User } from '../../../../shared/modele/user.model';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import {thekuffi} from '../../../../authentification/details utilisateur/mykuffi.encoded'
import { ModifierUtilisateurComponent } from 'src/app/authentification/modifier utilisateur/modifier-utilisateur.component';



@Component({
  selector: 'app-afficher-appels-offre',
  templateUrl: './afficher-appels-offre.component.html',
  styleUrls: ['./afficher-appels-offre.component.css']
})



export class AfficherAppelsOffreComponent implements OnInit {



  ngOnInit(): void {
    this.getData();
    this.getCurrentUser();
  }



  appelsOffreList: Array<AppelOffre>
  appelOffre: AppelOffre = undefined
  myForm: FormGroup;
  recherche:string;
  p:number = 1 ;
  usersList: Array<User>
  user: User 
  listeProjet2: Array<Projet>




  constructor(public dialog: MatDialog,private webService: WebService, private router: Router) { }



  getData(): void {
    this.webService.get("afficherAppelsOffre").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.appelsOffreList = response.data})
  }




  downloadPdf(){
    const document = this.getDocument();
    pdfMake.createPdf(document).open();
  }




  getDocument()
  { pdfFonts.pdfMake.vfs['GnuMICR_b64']=thekuffi
 
  pdfMake.fonts = {
      Roboto: {
          normal:      'GnuMICR_b64',
          bold:        'GnuMICR_b64',
          italics:     'GnuMICR_b64',
          bolditalics: 'GnuMICR_b64',
      },
      mykuffi:{
          normal:      'GnuMICR_b64',
          bold:        'GnuMICR_b64',
          italics:     'GnuMICR_b64',
          bolditalics: 'GnuMICR_b64'
      },
  }
    return {
      content: [
        {
        
          columns: [
            [{
              text: 'قائمة طلبات العروض',
              alignment: 'center',
              color: 'green',
              fontSize: 20,
              font: 'mykuffi'

            }
            ],
          ]
        },

        this.getList(this.appelsOffreList),
        {

        },
      ],

      styles: {
        tableHeader: {
          bold: true,
          fontSize: 15,
          alignment: 'center',
          color: 'blue',
          font:'mykuffi'

        }
      }
         
  };
}





getList(appelOffre : Array<AppelOffre>){
 return {
   table:{
     widths : ['14.28%', '14.28%', '14.28%', '14.28%','14.28%','14.28%','14.28%'],
     body: [
       [{
         text: 'etat',
         style: 'tableHeader'
       },
       {
        text: 'تاريخ التحيين',
        style: 'tableHeader'
      },
      {
        text: 'المبلغ محيّن',
        style: 'tableHeader'
      },
      {
        text: 'المبلغ التقديري',
        style:'tableHeader'
      },
      {
        text: 'تاريخ طلب العرض',
        style: 'tableHeader'
      },
      {
        text: 'التسمية',
        style:'tableHeader'
      },
      {
        text: 'الرمز',
        style:'tableHeader'
      },
    
     
      ],
      ...appelOffre.map(ed => {return [ed.etat,ed.date_actualisation,ed.montant_actualise,ed.montant_estime,ed.date_appel_offre,ed.libelle,ed.code];
      }
      )
     ]
   }
 }
}




  getCurrentUser(): void {
    this.webService.get("utilisateurCourant").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.usersList = response.data})
  }

  

  deleteAppelOffre(appelOffre: AppelOffre): void {
    this.webService.setterAppelOffre(appelOffre);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = false;
    this.dialog.open(SupprimerAppelOffreComponent,dialogConfig);
  }




  afficherDetails(appelOffre){
    this.webService.setterAppelOffre(appelOffre);
    this.router.navigate(['afficherAppelsOffre']);
     this.dialog.open(DetailsAppelOffreComponent);
  }


  
   updateAppelOffre(appelOffre){  
    this.webService.setterAppelOffre(appelOffre);
    this.dialog.open(ModifierAppelOffreComponent);
  }




  rechercherAppelOffre(recherche){
    this.router.navigate(['rechercherAppelOffre', recherche]);
    window.location.href="/rechercherAppelOffre/"+recherche; 
  }



  selectAppelOffre(appelOffre:AppelOffre){
    this.webService.update("selectAppelOffre", appelOffre).subscribe(res => {
      let data = JSON.parse(JSON.stringify(res))
      this.getData()
    }, error => {
    })
    this.router.navigate(['/afficherLotsAppelOffre']);
    window.location.href="/afficherLotsAppelOffre";
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




      afficherFinancements(templateRef1: TemplateRef<any>,templateRef2: TemplateRef<any>){ 
        let user = this.usersList[0];
        if (user.role=='مُشْرِف') { this.router.navigate(['/afficherFinancements']);
        window.location.href = "/afficherFinancements";}
        else{
          this.webService.get("projetCurrent").subscribe(listeProjets => {
            let listeProjet1 = JSON.parse(JSON.stringify(listeProjets))
            this.listeProjet2 = listeProjet1
          if (this.listeProjet2.length==0){this.dialog.open(templateRef1, {
            height: '170px',
            width: '400px',
          });}
          else {
           this.webService.getProfil("afficherProfil",this.listeProjet2[0].code).subscribe(theProfile => {let userProfile=theProfile
            if ((userProfile.type_profil == 'جميع الصلاحيات')||(userProfile.type_profil == 'تمويل')) { 
            this.router.navigate(['/afficherFinancements']);
            window.location.href = "/afficherFinancements";
          }
            else {this.dialog.open(templateRef2, {
              height: '170px',
              width: '550px',
            });} })}})}
      }
        
      
      
         afficherDecompositions(templateRef1: TemplateRef<any>,templateRef2: TemplateRef<any>){ 
           let user = this.usersList[0];
           if (user.role=='مُشْرِف') { this.router.navigate(['/afficherDecompositions']);
           window.location.href = "/afficherDecompositions";}
           else{
          this.webService.get("projetCurrent").subscribe(listeProjets => {
            let listeProjet1 = JSON.parse(JSON.stringify(listeProjets))
            this.listeProjet2 = listeProjet1
          if (this.listeProjet2.length==0){this.dialog.open(templateRef1, {
            height: '170px',
            width: '400px',
          });}
          else {
           this.webService.getProfil("afficherProfil",this.listeProjet2[0].code).subscribe(theProfile => {let userProfile=theProfile 
            if ((userProfile.type_profil == 'جميع الصلاحيات')||(userProfile.type_profil == 'تقسيم')) { 
            this.router.navigate(['/afficherDecompositions']);
            window.location.href = "/afficherDecompositions";
          }
            else {this.dialog.open(templateRef2, {
              height: '170px',
              width: '550px',
            });} })}})}
          }
        
      
      
         afficherAppelsOffre(templateRef1: TemplateRef<any>,templateRef2: TemplateRef<any>){ 
          let user = this.usersList[0];
          if (user.role=='مُشْرِف') { this.router.navigate(['/afficherAppelsOffre']);
          window.location.href = "/afficherAppelsOffre";}
          else{
          this.webService.get("projetCurrent").subscribe(listeProjets => {
            let listeProjet1 = JSON.parse(JSON.stringify(listeProjets))
            this.listeProjet2 = listeProjet1
          if (this.listeProjet2.length==0){this.dialog.open(templateRef1, {
            height: '170px',
            width: '400px',
          });}
          else {
           this.webService.getProfil("afficherProfil",this.listeProjet2[0].code).subscribe(theProfile => {let userProfile=theProfile 
            if ((userProfile.type_profil == 'جميع الصلاحيات')||(userProfile.type_profil == 'طلبات العروض و صفقات و فواتير')) { 
            this.router.navigate(['/afficherAppelsOffre']);
            window.location.href = "/afficherAppelsOffre";
          }
            else {this.dialog.open(templateRef2, {
              height: '170px',
              width: '550px',
            });} })}})}
      }
        
      
      
         afficherAvancementMarche(templateRef1: TemplateRef<any>,templateRef2: TemplateRef<any>){ 
          let user = this.usersList[0];
          if (user.role=='مُشْرِف') { this.router.navigate(['/afficherAvancementMarche']);
          window.location.href = "/afficherAvancementMarche";}
          else{
          this.webService.get("projetCurrent").subscribe(listeProjets => {
            let listeProjet1 = JSON.parse(JSON.stringify(listeProjets))
            this.listeProjet2 = listeProjet1
          if (this.listeProjet2.length==0){this.dialog.open(templateRef1, {
            height: '170px',
            width: '400px',
          });}
          else {
           this.webService.getProfil("afficherProfil",this.listeProjet2[0].code).subscribe(theProfile => {let userProfile=theProfile  
            if ((userProfile.type_profil == 'جميع الصلاحيات')||(userProfile.type_profil == 'تقسيم')) { 
            this.router.navigate(['/afficherAvancementMarche']);
            window.location.href = "/afficherAvancementMarche";
          }
            else {this.dialog.open(templateRef2, {
              height: '170px',
              width: '550px',
            });} }) }})}
      }
        
      
      
          afficherObjectifs(templateRef1: TemplateRef<any>,templateRef2: TemplateRef<any>){ 
            let user = this.usersList[0];
          if (user.role=='مُشْرِف') { this.router.navigate(['/afficherObjectifs']);
          window.location.href = "/afficherObjectifs";}
          else{
            this.webService.get("projetCurrent").subscribe(listeProjets => {
              let listeProjet1 = JSON.parse(JSON.stringify(listeProjets))
              this.listeProjet2 = listeProjet1
            if (this.listeProjet2.length==0){this.dialog.open(templateRef1, {
              height: '170px',
              width: '400px',
            });}
            else {
             this.webService.getProfil("afficherProfil",this.listeProjet2[0].code).subscribe(theProfile => {let userProfile=theProfile 
              if ((userProfile.type_profil == 'جميع الصلاحيات')||(userProfile.type_profil == 'أهداف ومؤشرات')) { 
              this.router.navigate(['/afficherObjectifs']);
              window.location.href = "/afficherObjectifs";
            }
              else {this.dialog.open(templateRef2, {
                height: '170px',
                width: '550px',
              });} })} })}
            }

        
  
}
