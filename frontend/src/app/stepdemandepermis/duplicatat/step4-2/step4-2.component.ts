import { Component, OnInit } from '@angular/core';
import { UserService } from '../../../_services/user.service';
import { TokenStorageService } from '../../../_services/token-storage.service';

@Component({
  selector: 'app-step4-2',
  templateUrl: './step4-2.component.html',
  styleUrls: ['./step4-2.component.css']
})
export class Step4_2Component implements OnInit {

  currentUser: any;

  
  constructor(private token: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
  }

}
