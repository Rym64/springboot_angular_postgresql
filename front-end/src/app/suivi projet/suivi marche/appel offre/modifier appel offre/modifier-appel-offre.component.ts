import { Component, OnInit } from '@angular/core';
import { AppelOffre } from '../../../../shared/modele/appelOffre.model';
import { Router } from '@angular/router';
import { WebService } from '../../../../shared/sevices/web.service';
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { EnumEtatAppelOffre } from 'src/app/shared/modele/enumEtatAppelOffre.model';



@Component({
  selector: 'app-modifier-appel-offre',
  templateUrl: './modifier-appel-offre.component.html',
  styleUrls: ['./modifier-appel-offre.component.css'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    {provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]
    },
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})




export class ModifierAppelOffreComponent implements OnInit {



  private appelOffre:AppelOffre;
  etatAppelOffre = EnumEtatAppelOffre;
  etatsKeys=[];



  constructor(private webService:WebService,private router:Router) {
    this.etatsKeys=Object.keys(this.etatAppelOffre);
   }




  ngOnInit() {
    this.appelOffre=this.webService.getterAppelOffre();
  }




  processForm(){
       this.webService.update("modifierAppelOffre",this.appelOffre).subscribe((appelOffre)=>{
         console.log(appelOffre);
         this.router.navigate(['afficherAppelOffres']);
         window.location.href="afficherAppelOffres/";
       },(error)=>{
         console.log(error);
       });
  }


  

}
