import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../services/userservice.service';
import { Router } from '@angular/router';
import { User } from '../models/user.model';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

   currentUser: User = {
    first_name: '',
    last_name: '',
    adress: '',
    cin: '',    
    phone: '',
    email: '',
    pwd: ''
  };
  message = '';

  constructor(private service: UserserviceService,private router:Router) { }

  ngOnInit(): void {
     
  }
  doLogin() {
   this.router.navigate(["/home"]);
    }

    public signin(){
    this.router.navigate(["/signin"]);
    }
}
