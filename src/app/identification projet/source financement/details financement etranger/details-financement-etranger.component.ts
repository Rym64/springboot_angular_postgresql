import { Component, OnInit } from '@angular/core';
import { FinancementEtranger } from '../../../shared/modele/financementEtranger.model';
import { WebService } from '../../../shared/sevices/web.service';


@Component({
  selector: 'app-details-financement-etranger',
  templateUrl: './details-financement-etranger.component.html',
  styleUrls: ['./details-financement-etranger.component.css']
})



export class DetailsFinancementEtrangerComponent implements OnInit {



  private financementEtranger:FinancementEtranger;



  constructor(private webService:WebService) { }


  
  ngOnInit() {
    this.financementEtranger=this.webService.getterFinancementEtranger();
  }


}
