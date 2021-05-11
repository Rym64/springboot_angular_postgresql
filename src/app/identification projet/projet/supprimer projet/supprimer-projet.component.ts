import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Projet } from '../../../shared/modele/projet.model';
import { WebService } from '../../../shared/sevices/web.service';


@Component({
  selector: 'app-supprimer-projet',
  templateUrl: './supprimer-projet.component.html',
  styleUrls: ['./supprimer-projet.component.css']
})


export class SupprimerProjetComponent implements OnInit {


  private projet:Projet;
  


  constructor(private webService:WebService,private router:Router) { }



  ngOnInit() {
    this.projet=this.webService.getterProjet();
  }



  
  deleteProjet(){
  this.webService.deleteProjet("supprimerProjet", this.projet).subscribe(res => {
    let data = JSON.parse(JSON.stringify(res))
    this.router.navigate(['/afficherProjets']);
    window.location.href="/afficherProjets";
  }, error => {})
  }


}
