import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../services/userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-updateuser',
  templateUrl: './updateuser.component.html',
  styleUrls: ['./updateuser.component.css']
})
export class UpdateuserComponent implements OnInit {

  constructor(private service: UserserviceService,private router:Router) { }

  ngOnInit(): void {
  }

  public home(){
    this.router.navigate(["/home"]);
  }

  public profile(){
    this.router.navigate(["/profile"]);
  }
  
  public listuser(){
    this.router.navigate(["/listuser"]);
  }
  
  public updateuser(){
    this.router.navigate(["/updateuser"]);
  }

  public adduser(){
    this.router.navigate(["/adduser"]);

  }

  public updateusermsg(){
  alert("Update successful !!");
  this.router.navigate(["/updateuser"]);
}

  public notif(){}
  
  public logout(){
    this.router.navigate(["/login"]);
  }
  
}
