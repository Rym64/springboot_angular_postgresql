import { Component, OnInit, TemplateRef } from '@angular/core';
import { Facture } from '../../../../shared/modele/facture.model';
import { FormGroup} from '@angular/forms';
import { WebService } from '../../../../shared/sevices/web.service';
import { DetailsFactureComponent } from '../details facture/details-facture.component';
import { SupprimerFactureComponent } from '../supprimer facture/supprimer-facture.component';
import { Router,ActivatedRoute } from '@angular/router';
import { User } from '../../../../shared/modele/user.model';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import {thekuffi} from '../../../../authentification/details utilisateur/mykuffi.encoded'
import { Projet } from 'src/app/shared/modele/projet.model';
import { ModifierUtilisateurComponent } from 'src/app/authentification/modifier utilisateur/modifier-utilisateur.component';


@Component({
  selector: 'app-rechercher-facture',
  templateUrl: './rechercher-facture.component.html',
  styleUrls: ['./rechercher-facture.component.css']
})



export class RechercherFactureComponent implements OnInit {



  ngOnInit(): void {
    this.getData();
    this.getCurrentUser();
  }


  facturesList: Array<Facture>
  facture: Facture = undefined
  myForm: FormGroup;
  recherche:string;
  p:number = 1 ;
  usersList: Array<User>
  user: User 
  listeProjet2: Array<Projet>



  constructor(private route: ActivatedRoute,public dialog: MatDialog,private webService: WebService, private router: Router) { }



  getData(): void {
    this.recherche = this.route.snapshot.params['recherche'];
    this.webService.rechercher("rechercherFacture",this.recherche).subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.facturesList = response})
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
              text: ' البحث عن فاتورة',
              alignment: 'center',
              color: 'green',
              fontSize: 20,
              font: 'mykuffi'

            }
            ],
          ]
        },

        this.getList(this.facturesList),
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




getList(facture : Array<Facture>){
 return {
   table:{
     widths : ['19.9%', '19.9%', '19.9%', '19.9%','19.9%'],
     body: [
       [{
         text: 'تاريخ الدفع',
         style: 'tableHeader'
       },
     
      {
        text: 'المبلغ المدفوع',
        style: 'tableHeader'
      },
      {
        text: 'المبلغ ',
        style:'tableHeader'
      },
      {
        text: 'تاريخ الفاتورة',
        style:'tableHeader'
      },
      {
        text: 'الرمز',
        style:'tableHeader'
      },
    
     
      ],
      ...facture.map(ed => {return [ed.date_payement,ed.montant_paye,ed.montant,ed.date_facture,ed.code];
      }
      )
     ]
   }
 }
}




  deleteFacture(facture: Facture): void {
    this.webService.setterFacture(facture);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = false;
    this.dialog.open(SupprimerFactureComponent,dialogConfig);
  }




  afficherDetails(facture){
    this.webService.setterFacture(facture);
    this.router.navigate(['afficherFactures']);
    this.dialog.open(DetailsFactureComponent);
  }



  rechercherFacture(recherche){
    this.router.navigate(['rechercherFacture', recherche]);
    window.location.href="/rechercherFacture/"+recherche;
  }

  

   updateFacture(facture){  
    this.webService.setterFacture(facture);
    this.router.navigate(['modifierFacture']);
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