import { Component, OnInit } from '@angular/core';
import { AppelOffre } from '../../../../shared/modele/appelOffre.model';
import { WebService } from '../../../../shared/sevices/web.service';
import { Router } from '@angular/router';
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { EnumEtatAppelOffre } from 'src/app/shared/modele/enumEtatAppelOffre.model';




@Component({
  selector: 'app-ajouter-appel-offre',
  templateUrl: './ajouter-appel-offre.component.html',
  styleUrls: ['./ajouter-appel-offre.component.css'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    { provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]},
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})



export class AjouterAppelOffreComponent implements OnInit {

  

    appelOffre: AppelOffre = new AppelOffre();
    submitted = false;
    etatAppelOffre = EnumEtatAppelOffre;
    etatsKeys=[];
    


    constructor(private webService: WebService,private router: Router) {
        this.etatsKeys=Object.keys(this.etatAppelOffre);
       }



  
    ngOnInit() {
       
    }
  



    newAppelOffre(): void {
      this.submitted = false;
      this.appelOffre = new AppelOffre();
    }



   
    addAppelOffre() {
      this.webService.createAppelOffre("ajouterAppelOffre", this.appelOffre)
        .subscribe(data => console.log(data), error => console.log(error));
      this.appelOffre = new AppelOffre();
      this.gotoList();
    }



  
    onSubmit() {
      this.submitted = true;
      this.addAppelOffre();
    }
  


    gotoList() {
      this.router.navigate(['/afficherAppelsOffre']);
        window.location.href="/afficherAppelsOffre"
      }  
      
      

  }
  


