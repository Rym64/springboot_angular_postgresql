import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../services/userservice.service';
import { ActivatedRoute,Router } from '@angular/router';
import { User } from '../models/user.model';

@Component({
  selector: 'app-listuser',
  templateUrl: './listuser.component.html',
  styleUrls: ['./listuser.component.css']
})
export class ListuserComponent implements OnInit {
  users?: User[];
  selected?: User;
  currentIndex: number = -1;
  firstname: string = '';
  message: string = '';

  
  constructor(private userService: UserserviceService, private router:Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.queryParams
      .subscribe(params => {
          if (params.firstname) {
            this.getUsersByFirstname(params.firstname);
          } else {
            this.getUsers();
          }
        }
      );
  }

  getUsersByFirstname(firstname: string): void {
    this.userService.findByFirstname(firstname)
      .subscribe(
        data => {
          this.users = data;
        },
        error => {
          console.error(error);
        });
  }

  getUsers(): void {
    this.userService.list()
      .subscribe(
        data => {
          this.users = data;
        },
        error => {
          console.error(error);
        });
  }

  refreshList(): void {
    this.getUsers();
    this.selected = undefined;
    this.currentIndex = -1;
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

  searchFirstname(): void {
    this.selected = undefined;
    this.currentIndex = -1;

    this.userService.findByFirstname(this.firstname)
      .subscribe(
        data => {
          this.users = data;
        },
        error => {
          console.error(error);
        });
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
        });
  }

  public logout(){
  }

  public deleteuser(){
    alert("Successfully deleted !!");
  }
  
}