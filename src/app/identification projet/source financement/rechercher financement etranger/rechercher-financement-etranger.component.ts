import { Component, OnInit, TemplateRef } from '@angular/core';
import { FinancementEtranger } from '../../../shared/modele/financementEtranger.model';
import { Projet } from '../../../shared/modele/projet.model';
import { FormGroup} from '@angular/forms';
import { WebService } from '../../../shared/sevices/web.service';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import { ActivatedRoute,Router } from '@angular/router';
import { User } from '../../../shared/modele/user.model';
import { DetailsFinancementEtrangerComponent } from '../details financement etranger/details-financement-etranger.component';
import { SupprimerFinancementEtrangerComponent } from '../supprimer financement etranger/supprimer-financement-etranger.component';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import {thekuffi} from '../../../authentification/details utilisateur/mykuffi.encoded'
import { ModifierUtilisateurComponent } from 'src/app/authentification/modifier utilisateur/modifier-utilisateur.component';




@Component({
  selector: 'app-rechercher-financement-etranger',
  templateUrl: './rechercher-financement-etranger.component.html',
  styleUrls: ['./rechercher-financement-etranger.component.css']
})



export class RechercherFinancementEtrangerComponent implements OnInit {
  
  ngOnInit(): void {
    this.getFinancementsEtrangers();
    this.getCurrentUser();
  }

  
  financementsEtrangersList: Array<FinancementEtranger>
  financementEtranger: FinancementEtranger = undefined
  myForm: FormGroup;
  recherche2:string;
  usersList: Array<User>
  user: User 
  p1:number = 1 ;
  listeProjet2: Array<Projet>
  
 



  constructor(private route: ActivatedRoute,public dialog:MatDialog, private webService: WebService,private router: Router) { }





  getCurrentUser(): void {
    this.webService.get("utilisateurCourant").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.usersList = response.data})
  }

 

  
  getFinancementsEtrangers(): void {
    this.recherche2 = this.route.snapshot.params['recherche2'];
    this.webService.rechercher("rechercherFinancementEtranger",this.recherche2).subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.financementsEtrangersList = response})
  }

  

  

  deleteFinancementEtranger(financementEtranger: FinancementEtranger): void {
    this.webService.setterFinancementEtranger(financementEtranger);
      const dialogConfig = new MatDialogConfig();
      dialogConfig.autoFocus = false;
      this.dialog.open(SupprimerFinancementEtrangerComponent,dialogConfig);
  }

  
 

  update_financementEtranger(financementEtranger){  
    this.webService.setterFinancementEtranger(financementEtranger);
    this.router.navigate(['modifierFinancementEtranger']);
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
            text: '  البحث عن تمويل أجنبي   ',
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





  afficherDetailsFinancementEtranger(financementEtranger){
    this.webService.setterFinancementEtranger(financementEtranger);
    this.router.navigate(['afficherFinancementsEtranger']);
     this.dialog.open(DetailsFinancementEtrangerComponent);
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
