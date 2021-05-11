import { Component, OnInit } from '@angular/core';
import { UserProfilProjet } from '../../shared/modele/userProfilProjet.model';
import { User } from '../../shared/modele/user.model';
import { Projet } from '../../shared/modele/projet.model';
import { Profil } from '../../shared/modele/profil.model';
import { Router } from '@angular/router';
import { WebService } from '../../shared/sevices/web.service';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import { EnumTypeProfil } from 'src/app/shared/modele/enumTypeProfil.model';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})

export class AddComponent implements OnInit {

  projetsList1: Array<Projet>;
  usersList2 : Array<User>;
  typeProfil = EnumTypeProfil;
  profil: Profil = new Profil();
  user: User = new User();
  projet: Projet = new Projet();
  utilisateurProfilProjet: UserProfilProjet = new UserProfilProjet();
  typeProfilKeys=[];
  submitted = false;

  
  constructor(private webService: WebService,private router: Router) {
    this.typeProfilKeys=Object.keys(this.typeProfil);
   }


  ngOnInit() {
    this.getProjets();
    this.getUsers();
  }


  getProjets(): void {
    this.webService.get("trouverProjets").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.projetsList1 = response
    })
  }


  getUsers(): void {
    this.webService.get("trouverUtilisateurs").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.usersList2 = response
    })
  }


  newUtilisateurProfilProjet(): void {
    this.submitted = false;
    this.utilisateurProfilProjet = new UserProfilProjet();
  }

  

  addUtilisateurProfilProjet() {
    this.utilisateurProfilProjet.user=this.user;
    this.utilisateurProfilProjet.projet=this.projet;
    this.utilisateurProfilProjet.profil=this.profil;
    this.webService.createUserProfilProjet("ajouterProjet", this.utilisateurProfilProjet)
      .subscribe(data => console.log(data), error => console.log(error));
    this.utilisateurProfilProjet = new UserProfilProjet();
    this.gotoList();
  }


  onSubmit() {
    this.submitted = true;
    this.addUtilisateurProfilProjet();  
  }


  gotoList() {
    this.router.navigate(['afficherUserProfilProjet']);
    window.location.href = "/afficherUserProfilProjet";
  }

}
