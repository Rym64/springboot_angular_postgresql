import { Component, OnInit } from '@angular/core';
import { LotAppelOffre } from '../../../../shared/modele/lotAppelOffre.model';
import { Router } from '@angular/router';
import { WebService } from '../../../../shared/sevices/web.service';
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { EnumTypeLotAppelOffre } from 'src/app/shared/modele/enumTypeLotAppelOffre.model';



@Component({
  selector: 'app-modifier-lot-appel-offre',
  templateUrl: './modifier-lot-appel-offre.component.html',
  styleUrls: ['./modifier-lot-appel-offre.component.css'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    {provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]
    },
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})



export class ModifierLotAppelOffreComponent implements OnInit {



  private lotAppelOffre:LotAppelOffre;
  typeLot = EnumTypeLotAppelOffre;
  typesLotsKeys=[];



  constructor(private webService:WebService,private router:Router) {
    this.typesLotsKeys=Object.keys(this.typeLot);
   }




  ngOnInit() {
    this.lotAppelOffre=this.webService.getterLotAppelOffre();
  }




  processForm(){
       this.webService.update("modifierLotAppelOffre",this.lotAppelOffre).subscribe((lotAppelOffre)=>{
         console.log(lotAppelOffre);
         this.router.navigate(['afficherLotsAppelOffre']);
         window.location.href="afficherLotsAppelOffre/";
       },(error)=>{
         console.log(error);
       });
  }


  

}
