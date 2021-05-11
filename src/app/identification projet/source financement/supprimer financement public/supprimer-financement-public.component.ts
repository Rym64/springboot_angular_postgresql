import { Component, OnInit } from '@angular/core';
import { WebService } from '../../../shared/sevices/web.service';
import { Projet } from '../../../shared/modele/projet.model';
import { Router } from '@angular/router';



@Component({
  selector: 'app-supprimer-financement-public',
  templateUrl: './supprimer-financement-public.component.html',
  styleUrls: ['./supprimer-financement-public.component.css']
})



export class SupprimerFinancementPublicComponent implements OnInit {

  projetsList: Array<Projet>
  projet: Projet
  
  constructor(private webService:WebService,private router:Router) { }

  ngOnInit() {
  }



  deleteFinancementPublic(){
  this.webService.get("supprimerFinancementPublic").subscribe(res => {
    let data = JSON.parse(JSON.stringify(res))
    this.router.navigate(['/afficherFinancements']);
    window.location.href="/afficherFinancements";
  }, error => { })
}



}

