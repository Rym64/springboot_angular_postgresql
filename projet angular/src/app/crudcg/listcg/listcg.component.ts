import { Component, OnInit } from '@angular/core';
import { Cartegrise } from '../../models/cartegrise/cartegrise.module';
import { CartegriseService } from '../../_services/cartegrise.service';

@Component({
  selector: 'app-listcg',
  templateUrl: './listcg.component.html',
  styleUrls: ['./listcg.component.css']
})
export class ListcgComponent implements OnInit {
  selected?: Cartegrise;
  cgs: any;
  currentCartegrise = null;
  currentIndex = -1;
  firstname = '';
  constructor(private cgService: CartegriseService) { }

  ngOnInit() {
    this.retrieveCartegrises();
  }

  retrieveCartegrises() {
    this.cgService.getAll()
      .subscribe(
        data => {
          this.cgs = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList() {
    this.retrieveCartegrises();
    this.currentCartegrise = null;
    this.currentIndex = -1;
    this.selected = undefined;
  }

  setActiveCartegrise(cg, index) {
    this.currentCartegrise = cg;
    this.currentIndex = index;
  }

    setSelected(cg: Cartegrise, index: number): void {
    if (this.selected && this.selected.id == cg.id) {
      this.selected = undefined;
      this.currentIndex = -1;
    } else {
      this.selected = cg;
      this.currentIndex = index;
    }
  }

  deletCartegrise(): void {
    if (!this.selected) {
      return;
    }
    this.cgService.delete(this.selected.id)
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
    this.cgService.findByFirstname(this.firstname)
      .subscribe(
        data => {
          this.cgs = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

}

