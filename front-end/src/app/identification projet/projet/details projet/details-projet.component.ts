import { Component, OnInit } from '@angular/core';
import { Projet } from '../../../shared/modele/projet.model';
import { WebService } from '../../../shared/sevices/web.service';


@Component({
  selector: 'app-details-projet',
  templateUrl: './details-projet.component.html',
  styleUrls: ['./details-projet.component.css']
})



export class DetailsProjetComponent implements OnInit {

  private projet:Projet;

  constructor(private webService:WebService) { }

  ngOnInit() {
    this.projet=this.webService.getterProjet();
  }


}
