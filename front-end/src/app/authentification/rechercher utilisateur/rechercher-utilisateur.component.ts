import { Component, OnInit, TemplateRef } from '@angular/core';
import { User } from '../../shared/modele/user.model';
import { SupprimerUtilisateurComponent } from '../supprimer utilisateur/supprimer-utilisateur.component';
import { Router,ActivatedRoute } from '@angular/router';
import { WebService } from '../../shared/sevices/web.service';
import { FormGroup} from '@angular/forms';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import {thekuffi} from '../details utilisateur/mykuffi.encoded'
import { Projet } from 'src/app/shared/modele/projet.model';
import { Profil } from 'src/app/shared/modele/profil.model';


@Component({
  selector: 'app-rechercher-utilisateur',
  templateUrl: './rechercher-utilisateur.component.html',
  styleUrls: ['./rechercher-utilisateur.component.css']
})



export class RechercherUtilisateurComponent implements OnInit {


  ngOnInit(): void {
    this.getData();
    this.getCurrentUser();
  }


  usersList: Array<User>
  userList: Array<User> = null;
  usersList1: Array<User>;
  user: User 
  user1: User
  myForm: FormGroup;
  projetsList: Array<Projet>
  projet : Projet
  profilsList: Array<Profil>
  profil : Profil
  p:number = 1 ;
  recherche:string;
  listeProjet2: Array<Projet>


  constructor(private route: ActivatedRoute,public dialog: MatDialog,private webService: WebService,private router: Router) { }



  getData(): void {
    this.recherche = this.route.snapshot.params['recherche'];
    this.webService.rechercher("rechercherUtilisateur",this.recherche).subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.usersList = response })
  }

  

  deleteUser(user: User): void {
    this.webService.setterUser(user);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = false;
    this.dialog.open(SupprimerUtilisateurComponent,dialogConfig);  
  }



  getCurrentUser(): void {
    this.webService.get("utilisateurCourant").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.usersList1 = response.data})
  }

  
   updateUser(user){  
    this.webService.setterUser(user);
    this.router.navigate(['modifierUtilisateurs']);
  }


  rechercherUtilisateur(recherche){
    this.router.navigate(['rechercherUtilisateur', recherche]);
    window.location.href="/rechercherUtilisateur/"+recherche;  
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
              text: 'البحث عن مستخدم',
              alignment: 'center',
              color: 'green',
              fontSize: 20,
              font: 'mykuffi'

            }
            ],
          ]
        },

        this.getList(this.usersList),
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




getList(user : Array<User>){
 return {
   table:{
     widths : ['12.5%', '12.5%', '12.5%', '12.5%','12.5%','12.5%','12.5%','12.5%'],
     body: [
       [{
         text: 'الدور',
         style: 'tableHeader'
       },
       {
        text: 'الجنس',
        style: 'tableHeader'
      },
      {
        text: 'العنوان',
        style: 'tableHeader'
      },
      {
        text: 'تاريخ الولادة',
        style:'tableHeader'
      },
      {
        text: 'البريد الالكتروني',
        style:'tableHeader'
      },
      {
        text: 'إسم المستخدم',
        style:'tableHeader'
      },
      {
        text: 'اللقب',
        style:'tableHeader'
      },
      {
        text: 'الاسم',
        style:'tableHeader'
      },
      ],
      ...user.map(ed => {return [ed.role,ed.sexe,ed.adresse,ed.date_naissance,ed.email,ed.username,ed.last_name,ed.name];
      }
      )
     ]
   }
 }
}






loggedOut(){
  this.webService.loggedOut("loggedOut").subscribe(data => console.log(data), error => console.log(error));
  window.location.href="/afficherProjets";
}



afficherUtilisateurs()
{this.router.navigate(['/afficherUtilisateurs']);
 window.location.href="/afficherUtilisateurs";}



afficherUserProfilProjet()
{this.router.navigate(['/afficherUserProfilProjet']);
 window.location.href="/afficherUserProfilProjet";}


 

afficherProjets(){
  this.router.navigate(['/afficherProjets']);
  window.location.href="/afficherProjets";
}




 afficherFinancements(templateRef1: TemplateRef<any>,templateRef2: TemplateRef<any>){ 
    let user = this.usersList1[0];
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
       let user = this.usersList1[0];
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
      let user = this.usersList1[0];
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
      let user = this.usersList1[0];
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
        let user = this.usersList1[0];
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

