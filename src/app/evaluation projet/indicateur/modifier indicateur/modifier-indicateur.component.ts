import { Component, OnInit } from '@angular/core';
import { Indicateur } from '../../../shared/modele/indicateur.model';
import { WebService } from '../../../shared/sevices/web.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-modifier-indicateur',
  templateUrl: './modifier-indicateur.component.html',
  styleUrls: ['./modifier-indicateur.component.css']
})



export class ModifierIndicateurComponent implements OnInit {

 
  private indicateur:Indicateur;



  constructor(private webService: WebService,private router: Router) {
     }



     ngOnInit() {
      this.indicateur=this.webService.getterIndicateur();
    }
  


    processForm(){
         this.webService.update("modifierIndicateur",this.indicateur).subscribe((indicateur)=>{
           console.log(indicateur);
           this.router.navigate(['afficherIndicateurs']);
           window.location.href="afficherIndicateurs/";
         },(error)=>{
           console.log(error);
         });
      }

    }
