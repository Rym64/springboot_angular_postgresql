import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../services/userservice.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent implements OnInit {

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
  
  public adduser(){
    this.router.navigate(["/adduser"]);
  }

  public updateuser(){
    this.router.navigate(["/updateuser"]);
  }

  public addusermsg(){
    alert(" User successfully added !!");
    this.router.navigate(["/adduser"]);
  }

  public notif(){}
  
  public logout(){
    this.router.navigate(["/login"]);
  }
  
}
