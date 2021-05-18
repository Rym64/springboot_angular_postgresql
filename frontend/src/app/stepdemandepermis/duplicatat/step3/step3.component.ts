import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../_services/user.service';
import { TokenStorageService } from '../../../_services/token-storage.service';

@Component({
  selector: 'app-step3',
  templateUrl: './step3.component.html',
  styleUrls: ['./step3.component.css']
})
export class Step3Component implements OnInit {

  currentUser: any;

  
  constructor(private token: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
  }

}