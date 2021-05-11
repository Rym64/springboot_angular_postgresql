import { Component, OnInit } from '@angular/core';
import { User } from '../../shared/modele/user.model';
import { WebService } from '../../shared/sevices/web.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})


export class LoginComponent implements OnInit {

  user: User = new User();
  submittedUser = false;
  submittedAdmin = false;
  submittedAdminCni = false;
  customCollapsedHeight: string = '150px';
  customExpandedHeight: string = '150px';
  usersList: Array<User>;


  constructor(private webService: WebService, private router: Router) { }



  ngOnInit() {
    this.getCurrentUser();
  }



  loginUser() {
    this.webService.loginUser("loginUser", this.user).subscribe(data => {let valUser=data
     if (valUser == 0) { 
      this.router.navigate(['/afficherProjets']);
      window.location.href = "/afficherProjets";
    }})
  }


  loginAdmin() {
    this.webService.loginUser("loginAdmin", this.user).subscribe(data => {let valAdmin=data
      if (valAdmin == 0) { 
       this.router.navigate(['/afficherProjets']);
       window.location.href = "/afficherProjets";}})
  }




  loginAdminCni() {
    this.webService.loginUser("loginAdminCni", this.user).subscribe(data => {let valAdminCni=data
      if (valAdminCni == 0) { 
       this.router.navigate(['/afficherProjets']);
       window.location.href = "/afficherProjets";
     }})
  }

 
  onSubmitUser() {
    this.submittedUser = true;
    this.loginUser();
  }



  onSubmitAdmin() {
    this.submittedAdmin = true;
    this.loginAdmin();
  }



  onSubmitAdminCni() {
    this.submittedAdminCni = true;
    this.loginAdminCni();
  }



  getCurrentUser(): void {
    this.webService.get("utilisateurCourant").subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.usersList = response.data})
  }
  

}


