import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { WebService } from '../../../shared/sevices/web.service';
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { Projet } from '../../../shared/modele/projet.model';



@Component({
  selector: 'app-modifier-financement-public',
  templateUrl: './modifier-financement-public.component.html',
  styleUrls: ['./modifier-financement-public.component.scss'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    {
      provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]
    },
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})



export class ModifierFinancementPublicComponent implements OnInit {
  

  projetsList: Array<Projet>
  projet: Projet 


  constructor(private webService:WebService,private router:Router) { }



  ngOnInit() {
    this.projet=this.webService.getterProjet();
  }
  

  
  processForm(){
       this.webService.update("modifierProjet",this.projet).subscribe((projet)=>{
         console.log(projet);
         this.router.navigate(['afficherFinancements']);
         window.location.href="afficherFinancements/";
       },(error)=>{
         console.log(error);
       });
  }


}

