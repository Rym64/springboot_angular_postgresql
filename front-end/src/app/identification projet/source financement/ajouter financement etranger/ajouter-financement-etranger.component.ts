import { Component, OnInit } from '@angular/core';
import { FinancementEtranger } from '../../../shared/modele/financementEtranger.model';
import { WebService } from '../../../shared/sevices/web.service';
import { Router } from '@angular/router';
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { EnumPays } from 'src/app/shared/modele/enumPays.model';
import { EnumFinanceur } from 'src/app/shared/modele/enumFinanceur.model';
import { EnumDevise } from 'src/app/shared/modele/enumDevise.model';


@Component({
  selector: 'app-ajouter-financement-etranger',
  templateUrl: './ajouter-financement-etranger.component.html',
  styleUrls: ['./ajouter-financement-etranger.component.scss'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    { provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]},
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})



export class AjouterFinancementEtrangerComponent implements OnInit {



  financementEtranger: FinancementEtranger = new FinancementEtranger();
  submitted = false;
  pays = EnumPays;
  paysKeys=[];
  devise = EnumDevise;
  devisesKeys=[];
  financeur = EnumFinanceur;
  financeursKeys=[];


 
  constructor(private webService: WebService,private router: Router) {
      this.paysKeys=Object.keys(this.pays);
      this.financeursKeys=Object.keys(this.financeur);
      this.devisesKeys=Object.keys(this.devise);
     }



  ngOnInit() {
   
  }


  newFinancementEtranger(): void {
    this.submitted = false;
    this.financementEtranger = new FinancementEtranger();
  }
 


  addFinancementEtranger() {
    this.webService.createFinancementEtranger("ajouterFinancementEtranger", this.financementEtranger)
      .subscribe(data => console.log(data), error => console.log(error));
    this.financementEtranger = new FinancementEtranger();
    this.gotoList();
  }



  onSubmit() {
    this.submitted = true;
    this.addFinancementEtranger();
  }


  
  gotoList() {
    this.router.navigate(['afficherFinancements']);
    window.location.href = "/afficherFinancements";
  }

  
}
