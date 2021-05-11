import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Facture } from '../../../../shared/modele/facture.model';
import { WebService } from '../../../../shared/sevices/web.service';


@Component({
  selector: 'app-supprimer-facture',
  templateUrl: './supprimer-facture.component.html',
  styleUrls: ['./supprimer-facture.component.css']
})


export class SupprimerFactureComponent implements OnInit {

  private facture:Facture;
  
  constructor(private webService:WebService,private router: Router) { }

  ngOnInit() {
    this.facture=this.webService.getterFacture();
  }


  deleteFacture(){
  this.webService.deleteFacture("supprimerFacture", this.facture).subscribe(res => {
    let data = JSON.parse(JSON.stringify(res))
    this.router.navigate(['/afficherFactures']);
    window.location.href="/afficherFactures";
  }, error => {})
}

}
