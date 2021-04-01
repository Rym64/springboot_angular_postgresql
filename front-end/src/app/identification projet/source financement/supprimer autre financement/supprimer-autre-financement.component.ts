import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AutreFinancement } from '../../../shared/modele/autreFinancement.model';
import { WebService } from '../../../shared/sevices/web.service';


@Component({
  selector: 'app-supprimer-autre-financement',
  templateUrl: './supprimer-autre-financement.component.html',
  styleUrls: ['./supprimer-autre-financement.component.css']
})



export class SupprimerAutreFinancementComponent implements OnInit {

  private autreFinancement:AutreFinancement;
  
  constructor(private webService:WebService,private router:Router) { }


  
  ngOnInit() {
    this.autreFinancement=this.webService.getterAutreFinancement();
  }



  deleteAutreFinancement(){
  this.webService.deleteAutreFinancement("supprimerAutreFinancement", this.autreFinancement).subscribe(res => {
    let data = JSON.parse(JSON.stringify(res))
    this.router.navigate(['/afficherFinancements']);
    window.location.href="/afficherFinancements";
  }, error => {})
}



}

