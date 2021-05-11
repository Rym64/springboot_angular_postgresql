import { Component, OnInit } from '@angular/core';
import { User } from '../../shared/modele/user.model';
import { Router } from '@angular/router';
import { WebService } from '../../shared/sevices/web.service';
import { EnumGouvernorat } from 'src/app/shared/modele/enumGouvernorat.model';


@Component({
  selector: 'app-modifier-utilisateur',
  templateUrl: './modifier-utilisateur.component.html',
  styleUrls: ['./modifier-utilisateur.component.scss']
})


export class ModifierUtilisateurComponent implements OnInit {
  
  private user:User;
  gouvernorat = EnumGouvernorat;
  gouvernoratKeys=[];
  

  constructor(private webService:WebService,private router:Router) {
    this.gouvernoratKeys=Object.keys(this.gouvernorat);
   }



  ngOnInit() {
    this.user=this.webService.getterUser(); 
  }

  

  processForm(){
       this.webService.update("modifierUtilisateur",this.user).subscribe((user)=>{
         console.log(user);
         this.router.navigate(['/afficherUtilisateurs']);
         window.location.href="afficherUtilisateurs/";
       },(error)=>{
         console.log(error); }); 
  }


  
}

