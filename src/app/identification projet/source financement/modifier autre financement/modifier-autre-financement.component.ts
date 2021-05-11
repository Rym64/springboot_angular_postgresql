import { Component, OnInit } from '@angular/core';
import { AutreFinancement } from '../../../shared/modele/autreFinancement.model';
import { Router } from '@angular/router';
import { WebService } from '../../../shared/sevices/web.service';
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';



@Component({
  selector: 'app-modifier-autre-financement',
  templateUrl: './modifier-autre-financement.component.html',
  styleUrls: ['./modifier-autre-financement.component.scss'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    { provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]},
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})



export class ModifierAutreFinancementComponent implements OnInit {
  

  private autreFinancement:AutreFinancement;
 


  constructor(private webService:WebService,private router:Router) { }



  ngOnInit() {
    this.autreFinancement=this.webService.getterAutreFinancement();
  }



  processForm(){
       this.webService.update("modifierAutreFinancement",this.autreFinancement).subscribe((autreFinancement)=>{
         console.log(autreFinancement);
         this.router.navigate(['afficherFinancements']);
         window.location.href="afficherFinancements/";
       },(error)=>{
         console.log(error);});
  }

  
}

