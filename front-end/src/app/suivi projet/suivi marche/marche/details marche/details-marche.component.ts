import { Component, OnInit } from '@angular/core';
import { Marche } from '../../../../shared/modele/marche.model';
import { WebService } from '../../../../shared/sevices/web.service';


@Component({
  selector: 'app-details-marche',
  templateUrl: './details-marche.component.html',
  styleUrls: ['./details-marche.component.css']
})



export class DetailsMarcheComponent implements OnInit {


  private marche:Marche;


  constructor(private webService:WebService) { }

  
  ngOnInit() {
    this.marche=this.webService.getterMarche();
  }


}
