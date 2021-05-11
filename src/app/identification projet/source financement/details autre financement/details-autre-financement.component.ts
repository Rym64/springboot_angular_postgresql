import { Component, OnInit } from '@angular/core';
import { AutreFinancement } from '../../../shared/modele/autreFinancement.model';
import { WebService } from '../../../shared/sevices/web.service';


@Component({
  selector: 'app-details-autre-financement',
  templateUrl: './details-autre-financement.component.html',
  styleUrls: ['./details-autre-financement.component.css']
})



export class DetailsAutreFinancementComponent implements OnInit {

  private autreFinancement:AutreFinancement;



  constructor(private webService:WebService) { }



  ngOnInit() {
    this.autreFinancement=this.webService.getterAutreFinancement();
  }


}
