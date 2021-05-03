import { Component, OnInit } from '@angular/core';
import { Cartidentity } from '../../models/cartidentity/cartidentity.module';
import { CartidentityService } from '../../_services/cartidentity.service';

@Component({
  selector: 'app-list-cin',
  templateUrl: './list-cin.component.html',
  styleUrls: ['./list-cin.component.css']
})
export class ListCINComponent implements OnInit {
  selected?: Cartidentity;
  cins: any;
  currentCartidentity = null;
  currentIndex = -1;
  firstname = '';
  constructor(private cinService: CartidentityService) { }

  ngOnInit() {
    this.retrieveCartidentitys();
  }

  retrieveCartidentitys() {
    this.cinService.getAll()
      .subscribe(
        data => {
          this.cins = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList() {
    this.retrieveCartidentitys();
    this.currentCartidentity = null;
    this.currentIndex = -1;
    this.selected = undefined;
  }

  setActiveCartidentity(cin, index) {
    this.currentCartidentity = cin;
    this.currentIndex = index;
  }

    setSelected(cin: Cartidentity, index: number): void {
    if (this.selected && this.selected.id == cin.id) {
      this.selected = undefined;
      this.currentIndex = -1;
    } else {
      this.selected = cin;
      this.currentIndex = index;
    }
  }

  deletCartidentity(): void {
    if (!this.selected) {
      return;
    }
    this.cinService.delete(this.selected.id)
      .subscribe(
        response => {
          this.refreshList();
          alert("Successfully deleted !!");
        },
        error => {
          console.error(error);
        });
  }

  searchFirstname() {
    this.cinService.findByFirstname(this.firstname)
      .subscribe(
        data => {
          this.cins = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

}

