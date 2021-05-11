import { Component, OnInit } from '@angular/core';
import { Facture } from '../../../../shared/modele/facture.model';
import { WebService } from '../../../../shared/sevices/web.service';
import { Router } from '@angular/router';
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';


@Component({
  selector: 'app-ajouter-facture',
  templateUrl: './ajouter-facture.component.html',
  styleUrls: ['./ajouter-facture.component.scss'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    {provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]},
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})



export class AjouterFactureComponent implements OnInit {

 
  facture: Facture = new Facture();
  submitted = false;
  

  constructor(private webService: WebService,private router: Router) { }




  ngOnInit() {
    
   
  }



  newFacture(): void {
    this.submitted = false;
    this.facture = new Facture();
  }



 
  addFacture() {
    this.webService.createFacture("ajouterFacture", this.facture)
      .subscribe(data => console.log(data), error => console.log(error));
    this.facture = new Facture();
    this.gotoList();
  }




  onSubmit() {
    this.submitted = true;
    this.addFacture();
  }



  gotoList() {
    this.router.navigate(['/afficherFactures']);
    window.location.href="/afficherFactures"
  }
}



