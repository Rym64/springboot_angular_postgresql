import { Component, OnInit } from '@angular/core';
import { Projet } from '../../../shared/modele/projet.model';
import { Secteur } from '../../../shared/modele/secteur.model';
import { WebService } from '../../../shared/sevices/web.service';
import { Router } from '@angular/router';
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { EnumSecteur } from 'src/app/shared/modele/enumSecteur.model';
import { EnumGouvernorat } from 'src/app/shared/modele/enumGouvernorat.model';




@Component({
  selector: 'app-ajouter-projet',
  templateUrl: './ajouter-projet.component.html',
  styleUrls: ['./ajouter-projet.component.css'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    {provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]},
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})



export class AjouterProjetComponent implements OnInit {



  projet: Projet = new Projet();
  secteur: Secteur = new Secteur();
  enumSecteur = EnumSecteur;
  gouvernorat = EnumGouvernorat;
  secteurKeys=[];
  gouvernoratKeys=[];
  submitted = false;
  
  
  

  constructor(private webService: WebService,private router: Router) {
      this.secteurKeys=Object.keys(this.enumSecteur);
      this.gouvernoratKeys=Object.keys(this.gouvernorat);
     }
  


  ngOnInit() {
      } 
      
 

  newProjet(): void {
    this.submitted = false;
    this.projet = new Projet();
  }

 

  addProjet() {
    this.projet.secteur=this.secteur;
    this.webService.createProjet("ajouterProjet", this.projet)
      .subscribe(data => console.log(data), error => console.log(error));
    this.projet = new Projet();
    this.gotoList();
  }


  onSubmit() { 
    this.submitted = true;
    this.addProjet();  
  }


  
  
  gotoList() {
    this.router.navigate(['afficherProjets']);
    window.location.href = "/afficherProjets";
  }


  

}
 

