import { Component, OnInit, TemplateRef } from '@angular/core';
import { Marche } from '../../../../shared/modele/marche.model';
import { Projet } from '../../../../shared/modele/projet.model';
import { FormGroup} from '@angular/forms';
import { WebService } from '../../../../shared/sevices/web.service';
import { ModifierMarcheComponent } from '../modifier marche/modifier-marche.component';
import { Router } from '@angular/router';
import { SupprimerMarcheComponent } from '../supprimer marche/supprimer-marche.component';
import { DetailsMarcheComponent } from '../details marche/details-marche.component';
import { User } from '../../../../shared/modele/user.model';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import {thekuffi} from '../../../../authentification/details utilisateur/mykuffi.encoded'
import { ModifierUtilisateurComponent } from 'src/app/authentification/modifier utilisateur/modifier-utilisateur.component';



@Component({
  selector: 'app-afficher-marches',
  templateUrl: './afficher-marches.component.html',
  styleUrls: ['./afficher-marches.component.scss']
})



export class AfficherMarchesComponent implements OnInit {



  ngOnInit(): void {
    this.getData();
    this.getCurrentUser();
  }



  marchesList: Array<Marche>
  marche: Marche = undefined
  myForm: FormGroup;
  recherche:string;
  p:number = 1 ;
  usersList: Array<User>
  user: User 
  listeProjet2: Array<Projet>




  constructor(public dialog: MatDialog,private webService: WebService,private router: Router) { }



  getData(): void {
    this.webService.get("afficherMarches").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.marchesList = response.data})
  }




  getCurrentUser(): void {
    this.webService.get("utilisateurCourant").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.usersList = response.data})
  }




  rechercherMarche(recherche){
    this.router.navigate(['rechercherMarche', recherche]);
    window.location.href="/rechercherMarche/"+recherche; 
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
              text: 'قائمة الصفقات',
              alignment: 'center',
              color: 'green',
              fontSize: 20,
              font: 'mykuffi'

            }
            ],
          ]
        },

        this.getList(this.marchesList),
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




getList(marche : Array<Marche>){
 return {
   table:{
     widths : ['8.33%','8.33%','8.33%','8.33%','8.33%','8.33%','8.33%','8.33%','8.33%','8.33%','8.33%','8.33%' ],
     body: [
       [{
         text: 'مستوى التقدم',
         style: 'tableHeader'
       },
     
      {
        text: 'تاريخ الإنتهاء الفعلي',
        style: 'tableHeader'
      },
      {
        text: 'تاريخ الإنتهاء التقديري ',
        style:'tableHeader'
      },
      {
        text: 'مدة الأشغال',
        style:'tableHeader'
      },
      {
        text: '	تاريخ الامضاء',
        style:'tableHeader'
      },
      {
        text: 'البلد',
        style:'tableHeader'
      },
      {
        text: '	المبلغ بالدينار التونسي محيّن',
        style:'tableHeader'
      },
      {
        text: '	المبلغ بالدينار التونسي',
        style:'tableHeader'
      },
      {
        text: '	العملة',
        style:'tableHeader'
      },
     
      {
        text: '	المزوّد',
        style:'tableHeader'
      },
      {
        text: '	التسمية',
        style:'tableHeader'
      },
      {
        text: '	الرمز',
        style:'tableHeader'
      },
    
     
      ],
      ...marche.map(ed => {return [ed.niveau,ed.date_fin_travaux_reelle,ed.date_fin_travaux_estimee,ed.periode_travail,ed.date_signature,ed.pays_marche,ed.montant_actualise,ed.montant_dt,ed.devise,ed.fournisseur,ed.libelle,ed.code];
      }
      )
     ]
   }
 }
}
  



  deleteMarche(marche: Marche): void {
    this.webService.setterMarche(marche);
      const dialogConfig = new MatDialogConfig();
      dialogConfig.autoFocus = false;
       this.dialog.open(SupprimerMarcheComponent,dialogConfig);
  }


  
   updateMarche(marche){  
    this.webService.setterMarche(marche);
    this.dialog.open(ModifierMarcheComponent);
  }



  selectMarche(marche:Marche){
    this.webService.update("selectMarche", marche).subscribe(res => {
      let data = JSON.parse(JSON.stringify(res))
      this.getData()
    }, error => {
    })
    this.router.navigate(['/afficherFactures']);
    window.location.href="/afficherFactures";
  }



  updateUserCurrent(user){  
    this.webService.setterUser(user);
    this.dialog.open(ModifierUtilisateurComponent, {
      height: '700px',
      width: '500px',});
  }


  afficherDetails(marche){
    this.webService.setterMarche(marche);
    this.router.navigate(['afficherMarches']);
     this.dialog.open(DetailsMarcheComponent);
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
