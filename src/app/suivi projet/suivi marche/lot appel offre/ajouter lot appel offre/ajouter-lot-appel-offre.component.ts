import { Component, OnInit } from '@angular/core';
import { LotAppelOffre } from '../../../../shared/modele/lotAppelOffre.model';
import { WebService } from '../../../../shared/sevices/web.service';
import { Router } from '@angular/router';
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { EnumTypeLotAppelOffre } from 'src/app/shared/modele/enumTypeLotAppelOffre.model';




@Component({
  selector: 'app-ajouter-lot-appel-offre',
  templateUrl: './ajouter-lot-appel-offre.component.html',
  styleUrls: ['./ajouter-lot-appel-offre.component.css'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    {provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]
    },
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})



export class AjouterLotAppelOffreComponent implements OnInit {

 
  lotAppelOffre: LotAppelOffre = new LotAppelOffre();
  submitted = false;
  typeLot = EnumTypeLotAppelOffre;
  typesLotsKeys=[];
  


  constructor(private webService: WebService,private router: Router) {
      this.typesLotsKeys=Object.keys(this.typeLot);
     }




  ngOnInit() {
    
  }




  newLotAppelOffre(): void {
    this.submitted = false;
    this.lotAppelOffre = new LotAppelOffre();
  }



 
  addLotAppelOffre() {
    this.webService.createLotAppelOffre("ajouterLotAppelOffre", this.lotAppelOffre)
      .subscribe(data => console.log(data), error => console.log(error));
    this.lotAppelOffre = new LotAppelOffre();
    this.gotoList();
  }



  onSubmit() {
    this.submitted = true;
    this.addLotAppelOffre();
  }



  gotoList() {
    this.router.navigate(['/afficherLotsAppelOffre']);
    window.location.href="/afficherLotsAppelOffre"
  }

  
}



