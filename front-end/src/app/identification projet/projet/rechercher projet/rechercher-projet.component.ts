import { Component, OnInit, TemplateRef } from '@angular/core';
import { Projet } from '../../../shared/modele/projet.model';
import { FormGroup} from '@angular/forms';
import { WebService } from '../../../shared/sevices/web.service';
import { ModifierProjetComponent } from '../modifier projet/modifier-projet.component';
import { DetailsProjetComponent } from '../details projet/details-projet.component';
import { SupprimerProjetComponent } from '../supprimer projet/supprimer-projet.component';
import { ActivatedRoute,Router } from '@angular/router';
import { User } from '../../../shared/modele/user.model';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import {thekuffi} from '../../../authentification/details utilisateur/mykuffi.encoded'
import { ModifierUtilisateurComponent } from 'src/app/authentification/modifier utilisateur/modifier-utilisateur.component';


@Component({
  selector: 'app-rechercher-projet',
  templateUrl: './rechercher-projet.component.html',
  styleUrls: ['./rechercher-projet.component.css']
})



export class RechercherProjetComponent implements OnInit {
 
  ngOnInit(): void {
    this.getData();
    this.getCurrentUser();
  }


  projetsList: Array<Projet>
  projet: Projet = undefined
  myForm: FormGroup;
  p:number = 1 ;
  recherche:string;
  usersList: Array<User>
  user: User 
  listeProjet2: Array<Projet>



  constructor(private route: ActivatedRoute,public dialog: MatDialog,private webService: WebService,private router: Router) { }



  getData(): void {
    this.recherche = this.route.snapshot.params['recherche'];
    this.webService.rechercher("rechercherProjet",this.recherche).subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.projetsList = response})
  }



  getCurrentUser(): void {
    this.webService.get("utilisateurCourant").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.usersList = response.data})
  }

  

  deleteProjet(projet: Projet): void {
    this.webService.setterProjet(projet);
      const dialogConfig = new MatDialogConfig();
      dialogConfig.autoFocus = false;
      this.dialog.open(SupprimerProjetComponent,dialogConfig);
  }
  


  rechercherProjet(recherche){
    this.router.navigate(['rechercherProjet', recherche]);
    window.location.href="/rechercherProjet/"+recherche;  
  }



   updateProjet(projet){  
    this.webService.setterProjet(projet);
    this.dialog.open(ModifierProjetComponent);
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
              text: ' البحث عن مشروع',
              alignment: 'center',
              color: 'green',
              fontSize: 20,
              font: 'mykuffi'

            }
            ],
          ]
        },

        this.getList(this.projetsList),
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




getList(projet : Array<Projet>){
 return {
   table:{
     widths : ['7.68%', '7.68%', '7.68%', '7.68%','7.68%','7.68%','7.68%','7.68%','7.68%','7.68%','7.68%','7.68%','7.68%'],
     body: [
       [{
         text: 'الحالة',
         style: 'tableHeader'
       },
       {
        text: 'نسبة التقدم',
        style: 'tableHeader'
      },
      {
        text: 'مكان التنفيذ	',
        style: 'tableHeader'
      },
      {
        text: 'القطاع',
        style:'tableHeader'
      },
      {
        text: 'الكلفة التقديرية محيّنة',
        style:'tableHeader'
      },
      {
        text: 'الكلفة التقديرية',
        style:'tableHeader'
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
        text: 'تاريخ الإنطلاق محيّن',
        style:'tableHeader'
      },
      {
        text: 'تاريخ الإنطلاق',
        style:'tableHeader'
      },
      {
        text: 'الوصف',
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
      ...projet.map(ed => {return [ed.flag,ed.stade,ed.lieu_projet,ed.secteur.type_secteur,ed.cout_actualise,ed.cout,ed.date_fin_actualisee,ed.date_fin,ed.date_debut_actualisee,ed.date_debut,ed.description,ed.libelle,ed.code];
      }
      )
     ]
   }
 }
}





  afficherDetails(projet){
    this.webService.setterProjet(projet);
     this.dialog.open(DetailsProjetComponent);
  }





  selectProjet(projet:Projet){
    this.webService.update("selectProjet", projet).subscribe(res => {
      let data = JSON.parse(JSON.stringify(res))
      this.getData()
    }, error => {
    })
      let user = this.usersList[0];
        if (user.role=='مُشْرِف') { this.router.navigate(['/afficherFinancements']);
        window.location.href = "/afficherFinancements";}
        else{
    this.webService.getProfil("afficherProfil",projet.code).subscribe(theProfile => {let userProfile=theProfile
      if ((userProfile.type_profil == 'جميع الصلاحيات')||(userProfile.type_profil == 'تمويل')) { 
        this.router.navigate(['/afficherFinancements']);
        window.location.href = "/afficherFinancements";
      }
      if (userProfile.type_profil == 'طلبات العروض و صفقات و فواتير') { 
        this.router.navigate(['/afficherAppelsOffre']);
        window.location.href = "/afficherAppelsOffre";
      }
      if (userProfile.type_profil == 'أهداف ومؤشرات') { 
        this.router.navigate(['/afficherObjectifs']);
        window.location.href = "/afficherObjectifs";
      }})}
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