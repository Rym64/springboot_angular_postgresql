import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-profilecitoyen',
  templateUrl: './profilecitoyen.component.html',
  styleUrls: ['./profilecitoyen.component.css']
})
export class ProfilecitoyenComponent implements OnInit {
  currentUser: any;
  
  constructor(private token: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
  }

}
