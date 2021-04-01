import { Component, OnInit } from '@angular/core';
import { FinancementEtranger } from '../../../shared/modele/financementEtranger.model';
import { Router } from '@angular/router';
import { WebService } from '../../../shared/sevices/web.service';
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { EnumPays } from 'src/app/shared/modele/enumPays.model';
import { EnumDevise } from 'src/app/shared/modele/enumDevise.model';
import { EnumFinanceur } from 'src/app/shared/modele/enumFinanceur.model';



@Component({
  selector: 'app-modifier-financement-etranger',
  templateUrl: './modifier-financement-etranger.component.html',
  styleUrls: ['./modifier-financement-etranger.component.scss'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    { provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]
    },
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})



export class ModifierFinancementEtrangerComponent implements OnInit {
  
  
  private financementEtranger:FinancementEtranger;
  pays = EnumPays;
  paysKeys=[];
  devise = EnumDevise;
  devisesKeys=[];
  financeur = EnumFinanceur;
  financeursKeys=[];


  constructor(private webService:WebService,private router:Router) {
    this.paysKeys=Object.keys(this.pays);
      this.financeursKeys=Object.keys(this.financeur);
      this.devisesKeys=Object.keys(this.devise);
   }



  ngOnInit() {
    this.financementEtranger=this.webService.getterFinancementEtranger();
  }



  processForm(){
       this.webService.update("modifierFinancementEtranger",this.financementEtranger).subscribe((financementEtranger)=>{
         console.log(financementEtranger);
         this.router.navigate(['afficherFinancements']);
         window.location.href="afficherFinancements/";
       },(error)=>{
         console.log(error); });
  }



}

