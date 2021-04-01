import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserProfilProjet } from '../../shared/modele/userProfilProjet.model';
import { WebService } from '../../shared/sevices/web.service';


@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})



export class DeleteComponent implements OnInit {

  private userProfilProjet:UserProfilProjet;
  


  constructor(private webService:WebService,private router: Router) { }



  ngOnInit() {
    this.userProfilProjet=this.webService.getterUserProfilProjet();
  }


  deleteUserProfilProjet(){
  this.webService.deleteUserProfilProjet("supprimerUtilisateurProfilProjet", this.userProfilProjet).subscribe(res => {
    let data = JSON.parse(JSON.stringify(res))
    this.router.navigate(['/afficherUserProfilProjet']);
    window.location.href="/afficherUserProfilProjet";
  }, error => {})
}



}

