import { Component, OnInit, TemplateRef } from '@angular/core';
import { UserProfilProjet } from '../../shared/modele/userProfilProjet.model';
import { User } from '../../shared/modele/user.model';
import { Projet } from '../../shared/modele/projet.model';
import { DeleteComponent } from '../delete/delete.component';
import { Router,ActivatedRoute } from '@angular/router';
import { WebService } from '../../shared/sevices/web.service';
import { FormGroup} from '@angular/forms';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import {thekuffi} from '../../authentification/details utilisateur/mykuffi.encoded'
import { ModifierUtilisateurComponent } from 'src/app/authentification/modifier utilisateur/modifier-utilisateur.component';

@Component({
  selector: 'app-rechercher',
  templateUrl: './rechercher.component.html',
  styleUrls: ['./rechercher.component.css']
})


export class RechercherComponent implements OnInit {

 
  ngOnInit(): void {
    this.getData();
    this.getCurrentUser();
  }


  userProfilProjetsList: Array<UserProfilProjet>;
  userProfilProjet: UserProfilProjet 
  usersList1: Array<User>;
  user1: User
  myForm: FormGroup;
  recherche:string;
  listeProjet2: Array<Projet>
  p:number = 1 ;
 



  constructor(private route: ActivatedRoute,public dialog: MatDialog,private webService: WebService, private router: Router) { }



  getData(): void {
    this.recherche = this.route.snapshot.params['recherche'];
    this.webService.rechercher("rechercherUtilisateurProfilProjet",this.recherche).subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.userProfilProjetsList = response })
}

  

  deleteUserProfilProjet(userProfilProjet: UserProfilProjet): void {
    this.webService.setterUserProfilProjet(userProfilProjet);
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = false;
    this.dialog.open(DeleteComponent,dialogConfig);  
  }


  getCurrentUser(): void {
    this.webService.get("utilisateurCourant").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.usersList1 = response.data})
  }

 
  afficherDetailsProjet(projet:Projet){
    this.webService.setterProjet(projet);
    this.router.navigate(['/afficherDetailsProjet']);   
  }


  afficherDetailsUser(user:User){
    this.webService.setterUser(user);
    this.router.navigate(['/afficherDetailsUtilisateur']);   
  }
   

  rechercherUtilisateurProfilProjet(recherche){
    this.router.navigate(['rechercherUtilisateurProfilProjet', recherche]);
    window.location.href="/rechercherUtilisateurProfilProjet/"+recherche;
    
  }


   updateUserProfilProjet(userProfilProjet){ 
    this.webService.setterUserProfilProjet(userProfilProjet); 
    this.router.navigate(['modifierUtilisateurs']);
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
              text: ' البحث عن مهام المستخدمين حسب المشاريع ',
              alignment: 'center',
              color: 'green',
              fontSize: 20,
              font: 'mykuffi'

            }
            ],
          ]
        },

        this.getList(this.userProfilProjetsList),
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

getList(userProfilProjet : Array<UserProfilProjet>){
 return {
   table:{
     widths : ['33.3%', '33.3%', '33.3%'],
     body: [
       [{
         text: 'المستخدم',
         style: 'tableHeader'
       },
       {
        text: 'مهمة المستخدم',
        style: 'tableHeader'
      },
      {
        text: 'المشروع',
        style: 'tableHeader'
      },
   
      
      ],
      ...userProfilProjet.map(ed => {return [ed.projet,ed.profil,ed.user];
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
