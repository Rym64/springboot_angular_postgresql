import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Indicateur } from 'src/app/shared/modele/indicateur.model';
import { WebService } from 'src/app/shared/sevices/web.service';

@Component({
  selector: 'app-supprimer-indicateur',
  templateUrl: './supprimer-indicateur.component.html',
  styleUrls: ['./supprimer-indicateur.component.css']
})



export class SupprimerIndicateurComponent implements OnInit {

 
  private indicateur:Indicateur;
  


  constructor(private webService:WebService,private router: Router) { }



  ngOnInit() {
    this.indicateur=this.webService.getterIndicateur();
  }



  deleteIndicateur(){
  this.webService.deleteIndicateur("supprimerIndicateur", this.indicateur).subscribe(res => {
    let data = JSON.parse(JSON.stringify(res))
    this.router.navigate(['/afficherIndicateurs']);
    window.location.href="/afficherIndicateurs";
  }, error => {})
  }


}
