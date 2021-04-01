import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppelOffre } from '../../../../shared/modele/appelOffre.model';
import { WebService } from '../../../../shared/sevices/web.service';


@Component({
  selector: 'app-supprimer-appel-offre',
  templateUrl: './supprimer-appel-offre.component.html',
  styleUrls: ['./supprimer-appel-offre.component.css']
})



export class SupprimerAppelOffreComponent implements OnInit {



  private appelOffre:AppelOffre;


  
  constructor(private webService:WebService,private router:Router) { }



  ngOnInit() {
    this.appelOffre=this.webService.getterAppelOffre();
  }



  deleteAppelOffre(){
  this.webService.deleteAppelOffre("supprimerAppelOffre", this.appelOffre).subscribe(res => {
    let data = JSON.parse(JSON.stringify(res))
    this.router.navigate(['/afficherAppelOffres']);
    window.location.href="/afficherAppelOffres";
  }, error => {})
}




}

