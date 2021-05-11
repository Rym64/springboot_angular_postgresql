import { Component, OnInit, TemplateRef } from '@angular/core';
import { LotAppelOffre } from '../../../../shared/modele/lotAppelOffre.model';
import { Projet } from '../../../../shared/modele/projet.model';
import { FormGroup} from '@angular/forms';
import { WebService } from '../../../../shared/sevices/web.service';
import { ModifierLotAppelOffreComponent } from '../modifier lot appel offre/modifier-lot-appel-offre.component';
import { DetailsLotAppelOffreComponent } from '../details lot appel offre/details-lot-appel-offre.component';
import { SupprimerLotAppelOffreComponent } from '../supprimer lot appel offre/supprimer-lot-appel-offre.component';
import { Router } from '@angular/router';
import { User } from '../../../../shared/modele/user.model';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import {thekuffi} from '../../../../authentification/details utilisateur/mykuffi.encoded'
import { ModifierUtilisateurComponent } from 'src/app/authentification/modifier utilisateur/modifier-utilisateur.component';



@Component({
  selector: 'app-afficher-lots-appel-offre',
  templateUrl: './afficher-lots-appel-offre.component.html',
  styleUrls: ['./afficher-lots-appel-offre.component.css']
})



export class AfficherLotsAppelOffreComponent implements OnInit {



  ngOnInit(): void {
    this.getData();
    this.getCurrentUser();
  }



  lotsAppelOffreList: Array<LotAppelOffre>
  lotAppelOffre: LotAppelOffre = undefined
  myForm: FormGroup;
  recherche:string;
  p:number = 1 ;
  usersList: Array<User>
  user: User 
  listeProjet2: Array<Projet>




  constructor(public dialog: MatDialog,private webService: WebService, private router: Router) { }



  getData(): void {
    this.webService.get("afficherLotsAppelOffre").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.lotsAppelOffreList = response.data})
  }



  getCurrentUser(): void {
    this.webService.get("utilisateurCourant").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.usersList = response.data})
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
              text: 'قائمة دُفعات طلب العرض',
              alignment: 'center',
              color: 'green',
              fontSize: 20,
              font: 'mykuffi'

            }
            ],
          ]
        },

        this.getList(this.lotsAppelOffreList),
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





getList(lotAppelOffre : Array<LotAppelOffre>){
 return {
   table:{
     widths : ['24.9%', '24.9%', '24.9%', '24.9%'],
     body: [
       [{
         text: 'النوع',
         style: 'tableHeader'
       },
     
      {
        text: 'تاريخ الدُفعة',
        style: 'tableHeader'
      },
      {
        text: 'المبلغ ',
        style:'tableHeader'
      },
      {
        text: 'الرمز',
        style:'tableHeader'
      },
    
     
      ],
      ...lotAppelOffre.map(ed => {return [ed.type_lot,ed.date_lot,ed.montant,ed.code];
      }
      )
     ]
   }
 }
}




  deleteLotAppelOffre(lotAppelOffre: LotAppelOffre): void {
    this.webService.setterLotAppelOffre(lotAppelOffre);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = false;
    this.dialog.open(SupprimerLotAppelOffreComponent,dialogConfig);
  }


  selectLotAppelOffre(lotAppelOffre:LotAppelOffre){
    this.webService.update("selectLotAppelOffre", lotAppelOffre).subscribe(res => {
      let data = JSON.parse(JSON.stringify(res))
      this.getData()
    }, error => {
    })
    this.router.navigate(['/afficherMarches']);
    window.location.href="/afficherMarches";

  }




  afficherDetails(lotAppelOffre){
    this.webService.setterLotAppelOffre(lotAppelOffre);
    this.router.navigate(['afficherLotsAppelOffre']);
     this.dialog.open(DetailsLotAppelOffreComponent);
  }




  rechercherLotAppelOffre(recherche){
    this.router.navigate(['rechercherLotAppelOffre', recherche]);
    window.location.href="/rechercherLotAppelOffre/"+recherche; 
  }

  

   updateLotAppelOffre(lotAppelOffre){  
    this.webService.setterLotAppelOffre(lotAppelOffre);
    this.dialog.open(ModifierLotAppelOffreComponent);
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
