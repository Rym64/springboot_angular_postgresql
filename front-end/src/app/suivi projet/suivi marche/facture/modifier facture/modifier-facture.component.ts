import { Component, OnInit } from '@angular/core';
import { Facture } from '../../../../shared/modele/facture.model';
import { Router } from '@angular/router';
import { WebService } from '../../../../shared/sevices/web.service';
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';


@Component({
  selector: 'app-modifier-facture',
  templateUrl: './modifier-facture.component.html',
  styleUrls: ['./modifier-facture.component.scss'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    {provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]},
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})



export class ModifierFactureComponent implements OnInit {


  private facture:Facture;


  constructor(private webService:WebService,private router:Router) { }


  ngOnInit() {
    this.facture=this.webService.getterFacture();
  }



  processForm(){
       this.webService.update("modifierFacture",this.facture).subscribe((facture)=>{
         console.log(facture);
         this.router.navigate(['afficherFactures']);
         window.location.href="afficherFactures/";
       },(error)=>{
         console.log(error);
       }); 
  }



  
}
