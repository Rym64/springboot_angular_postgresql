import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Objectif } from '../../../shared/modele/objectif.model';
import { WebService } from '../../../shared/sevices/web.service';


@Component({
  selector: 'app-supprimer-objectif',
  templateUrl: './supprimer-objectif.component.html',
  styleUrls: ['./supprimer-objectif.component.css']
})



export class SupprimerObjectifComponent implements OnInit {


  private objectif:Objectif;
  


  constructor(private webService:WebService,private router: Router) { }



  ngOnInit() {
    this.objectif=this.webService.getterObjectif();
  }



  deleteObjectif(){
  this.webService.deleteObjectif("supprimerObjectif", this.objectif).subscribe(res => {
    let data = JSON.parse(JSON.stringify(res))
    this.router.navigate(['/afficherObjectifs']);
    window.location.href="/afficherObjectifs";
  }, error => {})
  }

  
}