import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../shared/modele/user.model';
import { WebService } from '../../shared/sevices/web.service';


@Component({
  selector: 'app-supprimer-utilisateur',
  templateUrl: './supprimer-utilisateur.component.html',
  styleUrls: ['./supprimer-utilisateur.component.css']
})


export class SupprimerUtilisateurComponent implements OnInit {

  private user:User;
  


  constructor(private webService:WebService,private router: Router) { }



  ngOnInit() {
    this.user=this.webService.getterUser();
  }


  deleteUser(){
  this.webService.deleteUser("supprimerUtilisateur", this.user).subscribe(res => {
    let data = JSON.parse(JSON.stringify(res))
    this.router.navigate(['/afficherUtilisateurs']);
    window.location.href="/afficherUtilisateurs";
  }, error => {})
}



}
