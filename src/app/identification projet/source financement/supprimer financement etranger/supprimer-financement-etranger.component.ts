import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FinancementEtranger } from '../../../shared/modele/financementEtranger.model';
import { WebService } from '../../../shared/sevices/web.service';


@Component({
  selector: 'app-supprimer-financement-etranger',
  templateUrl: './supprimer-financement-etranger.component.html',
  styleUrls: ['./supprimer-financement-etranger.component.css']
})



export class SupprimerFinancementEtrangerComponent implements OnInit {

  private financementEtranger:FinancementEtranger;
  


  constructor(private webService:WebService,private router:Router) { }



  ngOnInit() {
    this.financementEtranger=this.webService.getterFinancementEtranger();
  }



  deleteFinancementEtranger(){
  this.webService.deleteFinancementEtranger("supprimerFinancementEtranger", this.financementEtranger).subscribe(res => {
    let data = JSON.parse(JSON.stringify(res))
    this.router.navigate(['/afficherFinancements']);
    window.location.href="/afficherFinancements";
  }, error => {})
}



}

