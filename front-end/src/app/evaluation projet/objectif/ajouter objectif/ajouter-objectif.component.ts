import { Component, OnInit } from '@angular/core';
import { Objectif } from '../../../shared/modele/objectif.model';
import { WebService } from '../../../shared/sevices/web.service';
import { Router } from '@angular/router';
import { EnumTypeObjectif } from 'src/app/shared/modele/enumTypeObjectif.model';


@Component({
  selector: 'app-ajouter-objectif',
  templateUrl: './ajouter-objectif.component.html',
  styleUrls: ['./ajouter-objectif.component.css']
})



export class AjouterObjectifComponent implements OnInit {


  objectif: Objectif = new Objectif();
  typeObjectif = EnumTypeObjectif;
  typeObjectifKeys=[];
  submitted = false;
  

  constructor(private webService: WebService,private router: Router) {
      this.typeObjectifKeys=Object.keys(this.typeObjectif);
     }



  ngOnInit() {
      }  



  newObjectif(): void {
    this.submitted = false;
    this.objectif = new Objectif();
  }

  

  addObjectif() {
    this.webService.createObjectif("ajouterObjectif", this.objectif)
      .subscribe(data => console.log(data), error => console.log(error));
    this.objectif = new Objectif();
    this.gotoList();
  }


  onSubmit() {
    this.submitted = true;
    this.addObjectif();    
  }

  
  gotoList() {
    this.router.navigate(['afficherObjectifs']);
    window.location.href = "/afficherObjectifs";
  }

}
 

