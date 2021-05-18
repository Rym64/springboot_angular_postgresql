import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { User } from '../../models/user.model';
import { UserService } from '../../_services/user.service';

@Component({
  selector: 'app-formuser',
  templateUrl: './formuser.component.html',
  styleUrls: ['./formuser.component.css']
})
export class FormuserComponent implements OnInit {
  user: User = {
    username: '',
    firstname: '',
    lastname: '',
    image: '',
    address: '',
    phone: '',
    datebirth: '',
    email: '',
    password: ''
  };
  message = '';
  errorMessage = '';

  constructor(private userService: UserService, private router:Router, private route: ActivatedRoute) { }

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
        err => {
          this.errorMessage = err.error.message;
          
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
