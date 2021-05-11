import { Component, OnInit } from '@angular/core';
import { Projet } from '../../../shared/modele/projet.model';
import { Router } from '@angular/router';
import { WebService } from '../../../shared/sevices/web.service';
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { Secteur } from 'src/app/shared/modele/secteur.model';
import { EnumSecteur } from 'src/app/shared/modele/enumSecteur.model';
import { EnumGouvernorat } from 'src/app/shared/modele/enumGouvernorat.model';


@Component({
  selector: 'app-modifier-projet',
  templateUrl: './modifier-projet.component.html',
  styleUrls: ['./modifier-projet.component.css'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    {provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]},
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})



export class ModifierProjetComponent implements OnInit {
  
  private projet:Projet;
  secteur: Secteur = new Secteur();
  enumSecteur = EnumSecteur;
  gouvernorat = EnumGouvernorat;
  secteurKeys=[];
  gouvernoratKeys=[];

  constructor(private webService:WebService,private router:Router) {
     this.secteurKeys=Object.keys(this.enumSecteur);
    this.gouvernoratKeys=Object.keys(this.gouvernorat); 
  }



  ngOnInit() {
    this.projet=this.webService.getterProjet();
  }



  processForm(){
       this.webService.update("modifierProjet",this.projet).subscribe((projet)=>{
         console.log(projet);
         this.router.navigate(['afficherProjets']);
         window.location.href="afficherProjets/";
       },(error)=>{
         console.log(error);});
      }


}

