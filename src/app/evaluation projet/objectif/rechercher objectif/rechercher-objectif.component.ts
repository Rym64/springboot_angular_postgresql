import { Component, OnInit, TemplateRef } from '@angular/core';
import { Objectif } from '../../../shared/modele/objectif.model';
import { User } from '../../../shared/modele/user.model';
import { SupprimerObjectifComponent } from '../supprimer objectif/supprimer-objectif.component';
import { Router,ActivatedRoute } from '@angular/router';
import { WebService } from '../../../shared/sevices/web.service';
import { FormGroup} from '@angular/forms';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import {thekuffi} from '../../../authentification/details utilisateur/mykuffi.encoded'
import { Projet } from 'src/app/shared/modele/projet.model';
import { ModifierUtilisateurComponent } from 'src/app/authentification/modifier utilisateur/modifier-utilisateur.component';


@Component({
  selector: 'app-rechercher-objectif',
  templateUrl: './rechercher-objectif.component.html',
  styleUrls: ['./rechercher-objectif.component.css']
})



export class RechercherObjectifComponent implements OnInit {

  

  ngOnInit(): void {
    this.getData();
    this.getCurrentUser();
  }


  objectifsList: Array<Objectif>;
  objectif: Objectif = undefined
  usersList: Array<User>;
  recherche:string;
  user: User
  myForm: FormGroup;
  p:number = 1 ;
  listeProjet2: Array<Projet>



  constructor(private route: ActivatedRoute,public dialog: MatDialog,private webService: WebService, private router: Router) { }



  getData(): void {
    this.recherche = this.route.snapshot.params['recherche'];
    this.webService.rechercher("rechercherObjectif",this.recherche).subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.objectifsList = response})
    }

  

  deleteUser(objectif: Objectif): void {
    this.webService.setterObjectif(objectif);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = false;
    this.dialog.open(SupprimerObjectifComponent,dialogConfig);
  }



  getCurrentUser(): void {
    this.webService.get("utilisateurCourant").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.usersList = response.data})
  }


  
   updateObjectif(objectif){  
    this.webService.setterObjectif(objectif);
    this.router.navigate(['modifierObjectif']);
  }


  rechercherObjectif(recherche) {
    this.router.navigate(['rechercherObjectif', recherche]);
    window.location.href="/rechercherObjectif/"+recherche;
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
              text: 'البحث عن هدف  ',
              alignment: 'center',
              color: 'green',
              fontSize: 20,
              font: 'mykuffi'

            }
            ],
          ]
        },

        this.getList(this.objectifsList),
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




getList(objectif : Array<Objectif>){
 return {
   table:{
     widths : ['24.9%', '24.9%', '24.9%','24.9%'],
     body: [
       [
        {
          text: 'النوع ',
          style: 'tableHeader'
        },
        
        {
         text: 'الوصف  ',
         style: 'tableHeader'
       },

       {
        text: 'التسمية ',
        style: 'tableHeader'
      },
      
      {
        text: 'الرمز ',
        style: 'tableHeader'
      },
   
      
      ],
      ...objectif.map(ed => {return [ed.type_objectif,ed.description,ed.libelle,ed.code];
      }
      )
     ]
   }
 }
}




updateUserCurrent(user){  
  this.webService.setterUser(user);
      this.dialog.open(ModifierUtilisateurComponent, {
        height: '700px',
        width: '500px',});
}


loggedOut()
{this.webService.loggedOut("loggedOut")
.subscribe(data => console.log(data), error => console.log(error));
window.location.href="/afficherProjets";}





afficherUtilisateurs()
{this.router.navigate(['/afficherUtilisateurs']);
 window.location.href="/afficherUtilisateurs";}



afficherUserProfilProjet()
{this.router.navigate(['/afficherUserProfilProjet']);
 window.location.href="/afficherUserProfilProjet";}



 

afficherProjets()
{this.router.navigate(['/afficherProjets']);
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
