import { Component, OnInit } from '@angular/core';
import { LotAppelOffre } from '../../../../shared/modele/lotAppelOffre.model';
import { WebService } from '../../../../shared/sevices/web.service';


@Component({
  selector: 'app-details-lot-appel-offre',
  templateUrl: './details-lot-appel-offre.component.html',
  styleUrls: ['./details-lot-appel-offre.component.css']
})



export class DetailsLotAppelOffreComponent implements OnInit {


  private lotAppelOffre:LotAppelOffre;


  constructor(private webService:WebService) { }

  

  ngOnInit() {
    this.lotAppelOffre=this.webService.getterLotAppelOffre();
  }


}
