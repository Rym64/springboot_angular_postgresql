import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../_services/user.service';
import { TokenStorageService } from '../../../_services/token-storage.service';

@Component({
  selector: 'app-step4-4',
  templateUrl: './step4-4.component.html',
  styleUrls: ['./step4-4.component.css']
})
export class Step4_4Component implements OnInit {

  currentUser: any;

  
  constructor(private token: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
  }

}