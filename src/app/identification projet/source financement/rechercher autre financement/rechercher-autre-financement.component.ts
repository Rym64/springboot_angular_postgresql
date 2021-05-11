import { Component, OnInit, TemplateRef } from '@angular/core';
import { AutreFinancement } from '../../../shared/modele/autreFinancement.model';
import { Projet } from '../../../shared/modele/projet.model';
import { FormGroup} from '@angular/forms';
import { WebService } from '../../../shared/sevices/web.service';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import { ActivatedRoute,Router } from '@angular/router';
import { User } from '../../../shared/modele/user.model';
import { DetailsAutreFinancementComponent } from '../details autre financement/details-autre-financement.component';
import { SupprimerAutreFinancementComponent } from '../supprimer autre financement/supprimer-autre-financement.component';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import {thekuffi} from '../../../authentification/details utilisateur/mykuffi.encoded'
import { ModifierUtilisateurComponent } from 'src/app/authentification/modifier utilisateur/modifier-utilisateur.component';


@Component({
  selector: 'app-rechercher-autre-financement',
  templateUrl: './rechercher-autre-financement.component.html',
  styleUrls: ['./rechercher-autre-financement.component.css']
})


export class RechercherAutreFinancementComponent implements OnInit {
  
  ngOnInit(): void {
    this.getAutresFinancements();
    this.getCurrentUser();
  }



  autresFinancementsList: Array<AutreFinancement>
  autreFinancement: AutreFinancement = undefined
  myForm: FormGroup;
  recherche3:string;
  usersList: Array<User>
  user: User 
  p2:number = 1 ;
  listeProjet2: Array<Projet>
 



  constructor(private route: ActivatedRoute,public dialog:MatDialog, private webService: WebService,private router: Router) { }





  getCurrentUser(): void {
    this.webService.get("utilisateurCourant").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.usersList = response.data})
  }

  

 
  
  getAutresFinancements(): void {
    this.recherche3 = this.route.snapshot.params['recherche3'];
    this.webService.rechercher("rechercherAutreFinancement",this.recherche3).subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.autresFinancementsList = response})
  }

  



  deleteAutreFinancement(autreFinancement: AutreFinancement): void {
    this.webService.setterAutreFinancement(autreFinancement);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = false;
    this.dialog.open(SupprimerAutreFinancementComponent,dialogConfig);
  }
  
  


  updateAutreFinancement(autreFinancement){  
    this.webService.setterAutreFinancement(autreFinancement);
    this.router.navigate(['modifierAutreFinancement']);
  }



  updateUserCurrent(user){  
    this.webService.setterUser(user);
    this.dialog.open(ModifierUtilisateurComponent, {
      height: '700px',
      width: '500px',});
  }

 

  rechercherAutreFinancement(recherche3){
    this.router.navigate(['rechercherAutreFinancement', recherche3]);
    window.location.href="/rechercherAutreFinancement/"+recherche3;
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
            text: 'البحث عن تمويل آخر    ',
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




  afficherDetailsAutreFinancement(autreFinancement){
    this.webService.setterAutreFinancement(autreFinancement);
    this.router.navigate(['afficherAutresFinancement']);
     this.dialog.open(DetailsAutreFinancementComponent);
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
