import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LotAppelOffre } from '../../../../shared/modele/lotAppelOffre.model';
import { WebService } from '../../../../shared/sevices/web.service';


@Component({
  selector: 'app-supprimer-lot-appel-offre',
  templateUrl: './supprimer-lot-appel-offre.component.html',
  styleUrls: ['./supprimer-lot-appel-offre.component.css']
})



export class SupprimerLotAppelOffreComponent implements OnInit {



  private lotAppelOffre:LotAppelOffre;
  


  constructor(private webService:WebService,private router: Router) { }



  ngOnInit() {
    this.lotAppelOffre=this.webService.getterLotAppelOffre();
  }



  deleteLotAppelOffre(){
  this.webService.deleteLotAppelOffre("supprimerLotAppelOffre", this.lotAppelOffre).subscribe(res => {
    let data = JSON.parse(JSON.stringify(res))
    this.router.navigate(['/afficherLotsAppelOffre']);
    window.location.href="/afficherLotsAppelOffre";
  }, error => {})
}



}
