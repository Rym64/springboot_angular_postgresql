import { Component, OnInit } from '@angular/core';
import { Decomposition } from '../../../shared/modele/decomposition.model';
import { Router } from '@angular/router';
import { WebService } from '../../../shared/sevices/web.service';
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';



@Component({
  selector: 'app-modifier-decomposition',
  templateUrl: './modifier-decomposition.component.html',
  styleUrls: ['./modifier-decomposition.component.scss'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    {provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]},
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})



export class ModifierDecompositionComponent implements OnInit {


  private decomposition1:Decomposition;
 

  constructor(private webService:WebService,private router:Router) { }


  ngOnInit() {
    this.decomposition1=this.webService.getterDecomposition();
  }


  processForm(){
       this.webService.update("modifierDecomposition",this.decomposition1).subscribe((decomposition)=>{
         console.log(decomposition);
         this.router.navigate(['/afficherDecompositions']);
         window.location.href = "/afficherDecompositions";
       },(error)=>{
         console.log(error);});
  }
  

}
