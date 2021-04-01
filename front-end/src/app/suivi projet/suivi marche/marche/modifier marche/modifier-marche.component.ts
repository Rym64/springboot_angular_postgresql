import { Component, OnInit } from '@angular/core';
import { Marche } from '../../../../shared/modele/marche.model';
import { Router } from '@angular/router';
import { WebService } from '../../../../shared/sevices/web.service';
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { EnumPays } from 'src/app/shared/modele/enumPays.model';
import { EnumDevise } from 'src/app/shared/modele/enumDevise.model';



@Component({
  selector: 'app-modifier-marche',
  templateUrl: './modifier-marche.component.html',
  styleUrls: ['./modifier-marche.component.scss'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    { provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]
    },
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})



export class ModifierMarcheComponent implements OnInit {



  private marche:Marche;
  pays = EnumPays;
  paysKeys=[];
  devise = EnumDevise;
  devisesKeys=[];



  constructor(private webService:WebService,private router:Router) {
    this.paysKeys=Object.keys(this.pays);
      this.devisesKeys=Object.keys(this.devise);
   }




  ngOnInit() {
    this.marche=this.webService.getterMarche();
  }



  processForm(){
       this.webService.update("modifierMarche",this.marche).subscribe((marche)=>{
         console.log(marche);
         this.router.navigate(['/afficherMarches']);
         window.location.href="/afficherMarches";
       },(error)=>{
         console.log(error);
       });
  }


  

}
