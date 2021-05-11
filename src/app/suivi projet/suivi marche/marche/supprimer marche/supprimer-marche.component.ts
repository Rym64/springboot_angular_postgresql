import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Marche } from '../../../../shared/modele/marche.model';
import { WebService } from '../../../../shared/sevices/web.service';


@Component({
  selector: 'app-supprimer-marche',
  templateUrl: './supprimer-marche.component.html',
  styleUrls: ['./supprimer-marche.component.css']
})


export class SupprimerMarcheComponent implements OnInit {


  private marche:Marche;

  
  constructor(private webService:WebService,private router: Router) { }


  ngOnInit() {
    this.marche=this.webService.getterMarche();
  }


  deleteMarche(){
  this.webService.deleteMarche("supprimerMarche", this.marche).subscribe(res => {
    let data = JSON.parse(JSON.stringify(res))
    this.router.navigate(['/afficherMarches']);
    window.location.href="/afficherMarches";
  }, error => {})
}



}
