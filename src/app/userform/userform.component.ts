import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../services/userservice.service';
import { ActivatedRoute,Router } from '@angular/router';
import { User } from '../models/user.model';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserFormComponent implements OnInit {

  user: User = {
    firstname: '',
    lastname: '',
    address: '',
    phone: '',
    date_of_birth: '',
    email: '',
    password: ''
  };
  message = '';

  constructor(private userService: UserserviceService,private router:Router,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.message = '';
    const id = this.route.snapshot.params.id;
    if (id) {
      this.editUser(this.route.snapshot.params.id);
    }
  }

  editUser(id: string): void {
    this.userService.get(id)
      .subscribe(
        data => {
          this.user = data;
        },
        error => {
          console.error(error);
        });
  }

  saveUser(): void {
    this.message = '';
    if (this.user.id) {
      this.saveEditedUser();
    }
    else{
      this.createNewUser();
    } 
  }

  private createNewUser() {
    this.userService.create(this.user)
      .subscribe(
        response => {
          this.router.navigate([ '/listuser' ]);
          alert("User added successfully !!");
        },
        error => {
          console.error(error);
          this.message = 'An error occurred while saving user';
        });
  }

  private saveEditedUser() {
    this.userService.update(this.user.id, this.user)
      .subscribe(
        response => {
          this.router.navigate([ '/listuser' ]);
          alert("User updated successfully !!");
        },
        error => {
          console.error(error);
          this.message = 'An error occurred while saving user';
        });
  }

}
