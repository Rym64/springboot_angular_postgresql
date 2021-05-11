import { Component, OnInit } from '@angular/core';
import { Decomposition } from '../../../shared/modele/decomposition.model';
import { WebService } from '../../../shared/sevices/web.service';


@Component({
  selector: 'app-details-decomposition',
  templateUrl: './details-decomposition.component.html',
  styleUrls: ['./details-decomposition.component.css']
})



export class DetailsDecompositionComponent implements OnInit {

  private decomposition:Decomposition;

  constructor(private webService:WebService) { }

  ngOnInit() {
    this.decomposition=this.webService.getterDecomposition();
  }


}
