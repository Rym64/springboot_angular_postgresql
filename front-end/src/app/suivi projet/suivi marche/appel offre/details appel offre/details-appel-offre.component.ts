import { Component, OnInit } from '@angular/core';
import { AppelOffre } from '../../../../shared/modele/appelOffre.model';
import { WebService } from '../../../../shared/sevices/web.service';


@Component({
  selector: 'app-details-appel-offre',
  templateUrl: './details-appel-offre.component.html',
  styleUrls: ['./details-appel-offre.component.css']
})



export class DetailsAppelOffreComponent implements OnInit {



  private appelOffre:AppelOffre;



  constructor(private webService:WebService) { }


  
  ngOnInit() {
    this.appelOffre=this.webService.getterAppelOffre();
  }


}
