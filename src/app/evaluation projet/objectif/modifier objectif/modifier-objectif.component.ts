import { Component, OnInit } from '@angular/core';
import { Objectif } from '../../../shared/modele/objectif.model';
import { WebService } from '../../../shared/sevices/web.service';
import { Router } from '@angular/router';
import { EnumTypeObjectif } from 'src/app/shared/modele/enumTypeObjectif.model';


@Component({
  selector: 'app-modifier-objectif',
  templateUrl: './modifier-objectif.component.html',
  styleUrls: ['./modifier-objectif.component.css']
})



export class ModifierObjectifComponent implements OnInit {



  private objectif:Objectif;
  typeObjectif = EnumTypeObjectif;
  typeObjectifKeys=[];



  constructor(private webService: WebService,private router: Router) {
      this.typeObjectifKeys=Object.keys(this.typeObjectif);
     }



     ngOnInit() {
      this.objectif=this.webService.getterObjectif();
    }
  


    processForm(){
         this.webService.update("modifierObjectif",this.objectif).subscribe((objectif)=>{
           console.log(objectif);
           this.router.navigate(['afficherObjectifs']);
           window.location.href="afficherObjectifs/";
         },(error)=>{
           console.log(error);
         });
      }
    

}
