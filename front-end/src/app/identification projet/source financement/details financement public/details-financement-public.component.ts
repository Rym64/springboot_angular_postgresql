import { Component, OnInit } from '@angular/core';
import { Projet } from '../../../shared/modele/projet.model';
import { WebService } from '../../../shared/sevices/web.service';


@Component({
  selector: 'app-details-financement-public',
  templateUrl: './details-financement-public.component.html',
  styleUrls: ['./details-financement-public.component.css']
})



export class DetailsFinancementPublicComponent implements OnInit {


  projetsList: Array<Projet>
  projet: Projet 


  constructor(private webService:WebService) { }


  ngOnInit() {
    this.getCurrentProjet();
  }

  

  getCurrentProjet(): void {
    this.webService.get("projetCurrent").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.projetsList = response.data})
  }


}
