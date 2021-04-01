import { Component, OnInit } from '@angular/core';
import { Facture } from '../../../../shared/modele/facture.model';
import { WebService } from '../../../../shared/sevices/web.service';


@Component({
  selector: 'app-details-facture',
  templateUrl: './details-facture.component.html',
  styleUrls: ['./details-facture.component.css']
})


export class DetailsFactureComponent implements OnInit {

  private facture:Facture;

  constructor(private webService:WebService) { }

  ngOnInit() {
    this.facture=this.webService.getterFacture();
  }


}
