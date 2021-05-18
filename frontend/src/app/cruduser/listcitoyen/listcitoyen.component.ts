import { Component, OnInit } from '@angular/core';
import { UserService } from '../../_services/user.service';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-listcitoyen',
  templateUrl: './listcitoyen.component.html',
  styleUrls: ['./listcitoyen.component.css']
})
export class ListcitoyenComponent implements OnInit {
  selected?: User;
  users: any;
  currentUser = null;
  currentIndex: number = -1;
  username: string = '';
  message: string = '';

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.retrieveUsers();
  }

  retrieveUsers() {
    this.userService.getAll()
      .subscribe(
        data => {
          this.users = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList() {
    this.retrieveUsers();
    this.currentUser = null;
    this.currentIndex = -1;
    this.selected = undefined;
  }

  setActiveUser(user: null, index: number) {
    this.currentUser = user;
    this.currentIndex = index;
  }

    setSelected(user: User, index: number): void {
    if (this.selected && this.selected.id == user.id) {
      this.selected = undefined;
      this.currentIndex = -1;
    } else {
      this.selected = user;
      this.currentIndex = index;
    }
  }

  deleteUser(): void {
    if (!this.selected) {
      return;
    }
    this.userService.delete(this.selected.id)
      .subscribe(
        response => {
          this.refreshList();
          alert("Successfully deleted !!");
        },
        error => {
          console.error(error);
          this.message = 'An error occurred while deleting user';
        });
  }

  /*removeAllUsers() {
    this.userService.deleteAll()
      .subscribe(
        response => {
          console.log(response);
          this.refreshList();
        },
        error => {
          console.log(error);
        });
  }*/

  searchUsername() {
    this.userService.findByUsername(this.username)
      .subscribe(
        data => {
          this.users = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }


  

 

  /*searchUsers($event: any) {
    if ($event.keyCode === 13) {
      $event.preventDefault();
      $event.target.parentElement.submit();
    }
  }*/

}


