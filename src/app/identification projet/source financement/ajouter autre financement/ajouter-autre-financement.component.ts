import { Component, OnInit } from '@angular/core';
import { AutreFinancement } from '../../../shared/modele/autreFinancement.model';
import { WebService } from '../../../shared/sevices/web.service';
import { Router } from '@angular/router';
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';


@Component({
  selector: 'app-ajouter-autre-financement',
  templateUrl: './ajouter-autre-financement.component.html',
  styleUrls: ['./ajouter-autre-financement.component.scss'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    {provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]},
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})




export class AjouterAutreFinancementComponent implements OnInit {



  autreFinancement: AutreFinancement = new AutreFinancement();
  submitted = false;
  


  constructor(private webService: WebService,private router: Router) { }



  ngOnInit() {
  }



  newAutreFinancement(): void {
    this.submitted = false;
    this.autreFinancement = new AutreFinancement();
  }



 
  addAutreFinancement() {
    this.webService.createAutreFinancement("ajouterAutreFinancement", this.autreFinancement)
      .subscribe(data => console.log(data), error => console.log(error));
    this.autreFinancement = new AutreFinancement();
    this.gotoList();
  }




  onSubmit() {
    this.submitted = true;
    this.addAutreFinancement();
  }




  gotoList() {
    this.router.navigate(['afficherFinancements']);
    window.location.href = "/afficherFinancements";
  }


  
}
