import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../services/userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  users:any;
  constructor(private service: UserserviceService,private router:Router) { }

  ngOnInit() {
  }

}
