import { Component, OnInit, TemplateRef } from '@angular/core';
import { Decomposition } from '../../../shared/modele/decomposition.model';
import { Projet } from '../../../shared/modele/projet.model';
import { FormGroup} from '@angular/forms';
import { WebService } from '../../../shared/sevices/web.service';
import { Router } from '@angular/router';
import { User } from '../../../shared/modele/user.model';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { SupprimerDecompositionComponent } from '../supprimer decomposition/supprimer-decomposition.component';
import { DetailsDecompositionComponent } from '../details decomposition/details-decomposition.component';
import { ModifierDecompositionComponent } from '../modifier decomposition/modifier-decomposition.component';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import {thekuffi} from '../../../authentification/details utilisateur/mykuffi.encoded'
import { EnumTypeDecomposition } from 'src/app/shared/modele/enumTypeDecomposition.model';
import { ModifierUtilisateurComponent } from 'src/app/authentification/modifier utilisateur/modifier-utilisateur.component';



@Component({
  selector: 'app-afficher-decompositions',
  templateUrl: './afficher-decompositions.component.html',
  styleUrls: ['./afficher-decompositions.component.css'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    {provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]},
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})


export class AfficherDecompositionsComponent implements OnInit {



  ngOnInit(): void {
    this.getData();
    this.getCurrentUser();
  }


  decompositionsList: Array<Decomposition>
  decomposition: Decomposition = undefined
  decomposition1: Decomposition = new Decomposition();
  myForm: FormGroup;
  typeDecomposition = EnumTypeDecomposition;
  typeDecompositionKeys=[];
  submitted = false;
  recherche:string;
  usersList: Array<User>
  user: User
  listeProjet2: Array<Projet>

  constructor(public dialog: MatDialog,private webService: WebService,private router: Router) {
    this.typeDecompositionKeys=Object.keys(this.typeDecomposition);
   }



  getData(): void {
    this.webService.get("afficherDecompositions").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.decompositionsList = response.data})
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
              text: 'قائمة تقسيمات المشروع ',
              alignment: 'center',
              color: 'green',
              fontSize: 20,
              font: 'mykuffi'

            }
            ],
          ]
        },

        this.getList(this.decompositionsList),
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




getList(decomposition : Array<Decomposition>){
 return {
   table:{
     widths : ['11.1%', '11.1%', '11.1%', '11.1%','11.1%','11.1%','11.1%','11.1%','11.1%'],
     body: [
       [{
         text: 'نسبة التقدم',
         style: 'tableHeader'
       },
       {
        text: 'النوع',
        style: 'tableHeader'
      },
    
     
      {
        text: 'تاريخ الإنتهاء محيّن',
        style:'tableHeader'
      },
      {
        text: 'تاريخ الإنتهاء',
        style:'tableHeader'
      },
      {
        text: 'تاريخ الإنطلاق محيّن ',
        style:'tableHeader'
      },
      {
        text: 'تاريخ الإنطلاق',
        style:'tableHeader'
      },
      {
        text: 'الكلفة التقديرية',
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
      ...decomposition.map(ed => {return [ed.niveau_decomposition,ed.type_decomposition,ed.date_fin_actualisee,ed.date_fin,ed.date_debut_actualisee,ed.date_debut,ed.montant,ed.libelle,ed.code];
      }
      )
     ]
   }
 }
}


  
  rechercherDecomposition(recherche){
    this.router.navigate(['rechercherDecomposition', recherche]); 
  }



  deleteDecomposition(decomposition: Decomposition): void {
    this.webService.setterDecomposition(decomposition);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = false;
    this.dialog.open(SupprimerDecompositionComponent,dialogConfig);
  }
  
   

   updateDecomposition(decomposition){  
    this.webService.setterDecomposition(decomposition);
    this.dialog.open(ModifierDecompositionComponent);
  }



  newDecomposition(): void {
    this.submitted = false;
    this.decomposition1 = new Decomposition();
  }
 
  

  addDecomposition(decomposition) {
    if (decomposition==null){
    this.decomposition1.degres_decomposition=0;}
    else {this.decomposition1.decomposition_mere=decomposition.code;
      this.decomposition1.degres_decomposition=decomposition.degres_decomposition+1;}
    this.webService.createDecomposition("ajouterDecomposition", this.decomposition1)
      .subscribe(data => console.log(data), error => console.log(error));
    this.decomposition1 = new Decomposition();
    this.gotoList();
  }



  afficherDetails(decomposition){
    this.webService.setterDecomposition(decomposition);
    this.router.navigate(['afficherDecompositions']);
     this.dialog.open(DetailsDecompositionComponent);
  }



  onSubmit(decomposition) {
    this.submitted = true;
    this.addDecomposition(decomposition);
  }



  gotoList() {
    this.router.navigate(['/afficherDecompositions']);
    window.location.href="/afficherDecompositions";
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
   window.location.href="/login";}




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
