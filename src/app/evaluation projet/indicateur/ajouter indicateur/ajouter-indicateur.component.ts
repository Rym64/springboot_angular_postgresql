import { Component, OnInit } from '@angular/core';
import { Indicateur } from '../../../shared/modele/indicateur.model';
import { WebService } from '../../../shared/sevices/web.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-ajouter-indicateur',
  templateUrl: './ajouter-indicateur.component.html',
  styleUrls: ['./ajouter-indicateur.component.css']
})



export class AjouterIndicateurComponent implements OnInit {


  indicateur: Indicateur = new Indicateur();
  submitted = false;
  

  constructor(private webService: WebService,private router: Router) {}

  ngOnInit() {
      }  

  newIndicateur(): void {
    this.submitted = false;
    this.indicateur = new Indicateur();
  }

  

  addIndicateur() {
    this.webService.createIndicateur("ajouterIndicateur", this.indicateur)
      .subscribe(data => console.log(data), error => console.log(error));
    this.indicateur = new Indicateur();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.addIndicateur();    
  }


  gotoList() {
    this.router.navigate(['afficherIndicateurs']);
    window.location.href = "/afficherIndicateurs";
  }

}
 

