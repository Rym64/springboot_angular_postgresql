import { Component, OnInit } from '@angular/core';
import { User } from '../models/user.model';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

   currentUser: User = {
    firstname: '',
    lastname: '',
    address: '',   
    phone: '',
    email: '',
    password: ''
  };
  message = '';

  constructor() { }

  ngOnInit(): void {
     
  }

}
