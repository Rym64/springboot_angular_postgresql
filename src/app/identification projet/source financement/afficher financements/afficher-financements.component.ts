import { Component, OnInit, TemplateRef } from '@angular/core';
import { FinancementEtranger } from '../../../shared/modele/financementEtranger.model';
import { AutreFinancement } from '../../../shared/modele/autreFinancement.model';
import { Projet } from '../../../shared/modele/projet.model';
import { FormGroup} from '@angular/forms';
import { WebService } from '../../../shared/sevices/web.service';
import { ModifierFinancementEtrangerComponent } from '../modifier financement etranger/modifier-financement-etranger.component';
import { ModifierAutreFinancementComponent } from '../modifier autre financement/modifier-autre-financement.component';
import { ModifierFinancementPublicComponent } from '../modifier financement public/modifier-financement-public.component';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import { Router } from '@angular/router';
import { User } from '../../../shared/modele/user.model';
import { DetailsFinancementPublicComponent } from '../details financement public/details-financement-public.component';
import { DetailsFinancementEtrangerComponent } from '../details financement etranger/details-financement-etranger.component';
import { DetailsAutreFinancementComponent } from '../details autre financement/details-autre-financement.component';
import { SupprimerFinancementEtrangerComponent } from '../supprimer financement etranger/supprimer-financement-etranger.component';
import { SupprimerAutreFinancementComponent } from '../supprimer autre financement/supprimer-autre-financement.component';
import { SupprimerFinancementPublicComponent } from '../supprimer financement public/supprimer-financement-public.component';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import {thekuffi} from '../../../authentification/details utilisateur/mykuffi.encoded'
import { ModifierUtilisateurComponent } from 'src/app/authentification/modifier utilisateur/modifier-utilisateur.component';




@Component({
  selector: 'app-afficher-financements',
  templateUrl: './afficher-financements.component.html',
  styleUrls: ['./afficher-financements.component.css']
})



export class AfficherFinancementsComponent implements OnInit {


  ngOnInit(): void {
    this.getFinancementsEtrangers();
    this.getAutresFinancements();
    this.getCurrentUser();
    this.getCurrentProjet();
  }

  
  financementsEtrangersList: Array<FinancementEtranger>
  financementEtranger: FinancementEtranger = undefined
  autresFinancementsList: Array<AutreFinancement>
  autreFinancement: AutreFinancement = undefined
  myForm: FormGroup;
  recherche1:string;
  recherche2:string;
  recherche3:string;
  usersList: Array<User>
  user: User 
  projetsList: Array<Projet>
  projet: Projet = undefined
  p1:number = 1 ;
  p2:number = 1 ;
  listeProjet2: Array<Projet>
 



  constructor(public dialog:MatDialog, private webService: WebService,private router: Router) { }




  getCurrentUser(): void {
    this.webService.get("utilisateurCourant").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.usersList = response.data})
  }



  getCurrentProjet(): void {
    this.webService.get("projetCurrent").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.projetsList = response})
  }

  

  getFinancementsEtrangers(): void {
    this.webService.get("afficherFinancementsEtrangers").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.financementsEtrangersList = response.data})
  }


  
  getAutresFinancements(): void {
    this.webService.get("afficherAutresFinancements").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.autresFinancementsList = response.data})
  }

  

  deleteFinancementPublic(): void {
      const dialogConfig = new MatDialogConfig();
      dialogConfig.autoFocus = false;
      this.dialog.open(SupprimerFinancementPublicComponent,dialogConfig);
  }



  deleteFinancementEtranger(financementEtranger: FinancementEtranger): void {
    this.webService.setterFinancementEtranger(financementEtranger);
      const dialogConfig = new MatDialogConfig();
      dialogConfig.autoFocus = false;
      this.dialog.open(SupprimerFinancementEtrangerComponent,dialogConfig);
  }




  deleteAutreFinancement(autreFinancement: AutreFinancement): void {
    this.webService.setterAutreFinancement(autreFinancement);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = false;
    this.dialog.open(SupprimerAutreFinancementComponent,dialogConfig);
  }
  


   update_financementPublic(projet){  
    this.webService.setterProjet(projet);
    this.dialog.open(ModifierFinancementPublicComponent);
  }




  update_financementEtranger(financementEtranger){  
    this.webService.setterFinancementEtranger(financementEtranger);
    this.dialog.open(ModifierFinancementEtrangerComponent);
  }



  updateAutreFinancement(autreFinancement){  
    this.webService.setterAutreFinancement(autreFinancement);
    this.dialog.open(ModifierAutreFinancementComponent);
  }



  updateUserCurrent(user){  
    this.webService.setterUser(user);
    this.dialog.open(ModifierUtilisateurComponent, {
      height: '700px',
      width: '500px',});
  }


  
  rechercherFinancementEtranger(recherche2){
    this.router.navigate(['rechercherFinancementEtranger', recherche2]);
    window.location.href="/rechercherFinancementEtranger/"+recherche2;  
  }



  rechercherAutreFinancement(recherche3){
    this.router.navigate(['rechercherAutreFinancement', recherche3]);
    window.location.href="/rechercherAutreFinancement/"+recherche3; 
  }



downloadPdf1(){
  const document1 = this.getDocument1();
  pdfMake.createPdf(document1).open();
  }



getDocument1()
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
            text: 'التمويل الحكومي',
            alignment: 'center',
            color: 'green',
            fontSize: 20,
            font: 'mykuffi'

          }
          ],
        ]
      },

      this.getList1(this.projetsList),
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




getList1(projet : Array<Projet>){
return {
 table:{
   widths : ['16.66%', '16.66%', '16.66%', '16.66%','16.66%','16.66%'],
   body: [
     [
     {
      text: 'تاريخ التحيين',
      style: 'tableHeader'
    },
    {
      text: 'المبلغ محيّن',
      style: 'tableHeader'
    },
    {
      text: 'المبلغ',
      style:'tableHeader'
    },
    {
      text: 'تاريخ التمويل',
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
    ...projet.map(ed => {return [ed.date_actualisation_financement_public,ed.montant_financement_public_actualise,ed.montant_financement_public,ed.date_financement_public,ed.libelle_financement_public,ed.code_financement_public];
    }
    )
   ]
 }
}
}




downloadPdf2(){
  const document2 = this.getDocument2();
  pdfMake.createPdf(document2).open();
}




getDocument2()
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
            text: 'قائمة التمويلات الأجنبية   ',
            alignment: 'center',
            color: 'green',
            fontSize: 20,
            font: 'mykuffi'

          }
          ],
        ]
      },

      this.getList2(this.financementsEtrangersList),
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




getList2(financementEtranger : Array<FinancementEtranger>){
return {
 table:{
   widths : ['9.09%', '9.09%', '9.09%', '9.09%','9.09%','9.09%','9.09%','9.09%','9.09%','9.09%','9.09%'],
   body: [
     [{
       text: 'آخر أجل للتمويل',
       style: 'tableHeader'
     },
     {
      text: 'تاريخ الإنتهاء',
      style: 'tableHeader'
    },
    {
      text: 'تاريخ الإنطلاق	',
      style: 'tableHeader'
    },
    {
      text: 'تاريخ الامضاء',
      style:'tableHeader'
    },
    {
      text: 'الممول',
      style:'tableHeader'
    },
    {
      text: 'تاريخ التحيين',
      style:'tableHeader'
    },
    {
      text: 'المبلغ بالدينار التونسي محيّن',
      style:'tableHeader'
    },
    {
      text: 'المبلغ بالدينار التونسي',
      style:'tableHeader'
    },
    {
      text: 'العملة',
      style:'tableHeader'
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
    ...financementEtranger.map(ed => {return [ed.date_delai,ed.date_cloture,ed.date_debut,ed.date_signature,ed.financeur,ed.date_actualisation,ed.montant_actualise,ed.montant_dt,ed.devise,ed.libelle,ed.code];
    }
    )
   ]
 }
}
}





downloadPdf3(){
  const document3 = this.getDocument3();
  pdfMake.createPdf(document3).open();
}





getDocument3()
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
            text: 'قائمة التمويلات الأخرى    ',
            alignment: 'center',
            color: 'green',
            fontSize: 20,
            font: 'mykuffi'

          }
          ],
        ]
      },

      this.getList3(this.autresFinancementsList),
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




getList3(autreFinancement : Array<AutreFinancement>){
return {
 table:{
   widths : ['16.66%', '16.66%', '16.66%', '16.66%','16.66%','16.66%'],
   body: [
     [{
       text: 'تاريخ التحيين',
       style: 'tableHeader'
     },
     {
      text: 'المبلغ محيّن',
      style: 'tableHeader'
    },
    {
      text: 'المبلغ بالدينار التونسي	',
      style: 'tableHeader'
    },
    {
      text: 'تاريخ التمويل',
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
    ...autreFinancement.map(ed => {return [ed.date_actualisation,ed.montant_actualise,ed.montant,ed.date_autre_financement,ed.libelle,ed.code];
    }
    )
   ]
 }
}
}




  afficherDetailsFinancementPublic(){
    this.router.navigate(['afficherFinancementsPublic']);
     this.dialog.open(DetailsFinancementPublicComponent);
  }



  afficherDetailsFinancementEtranger(financementEtranger){
    this.webService.setterFinancementEtranger(financementEtranger);
    this.router.navigate(['afficherFinancementsEtranger']);
     this.dialog.open(DetailsFinancementEtrangerComponent);
  }



  afficherDetailsAutreFinancement(autreFinancement){
    this.webService.setterAutreFinancement(autreFinancement);
    this.router.navigate(['afficherAutresFinancement']);
     this.dialog.open(DetailsAutreFinancementComponent);
  }



  

   loggedOut()
   {this.webService.loggedOut("loggedOut")
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
