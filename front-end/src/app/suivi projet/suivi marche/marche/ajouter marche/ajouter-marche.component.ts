import { Component, OnInit } from '@angular/core';
import { Marche } from '../../../../shared/modele/marche.model';
import { WebService } from '../../../../shared/sevices/web.service';
import { Router } from '@angular/router';
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { EnumPays } from 'src/app/shared/modele/enumPays.model';
import { EnumDevise } from 'src/app/shared/modele/enumDevise.model';



@Component({
  selector: 'app-ajouter-marche',
  templateUrl: './ajouter-marche.component.html',
  styleUrls: ['./ajouter-marche.component.scss'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    {provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]
    },
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})



export class AjouterMarcheComponent implements OnInit {

 
  marche: Marche = new Marche();
  submitted = false;
  pays = EnumPays;
  paysKeys=[];
  devise = EnumDevise;
  devisesKeys=[];
  


  constructor(private webService: WebService,private router: Router) {
      this.paysKeys=Object.keys(this.pays);
      this.devisesKeys=Object.keys(this.devise);
     }



  ngOnInit() {
   
  }


  newMarche(): void {
    this.submitted = false;
    this.marche = new Marche();
  }
 

  addMarche() {
    this.webService.createMarche("ajouterMarche", this.marche)
      .subscribe(data => console.log(data), error => console.log(error));
    this.marche = new Marche();
    this.gotoList();
  }


  onSubmit() {
    this.submitted = true;
    this.addMarche();
  }

  
  gotoList() {
    this.router.navigate(['/afficherMarches']);
    window.location.href="/afficherMarches"
  }
}



