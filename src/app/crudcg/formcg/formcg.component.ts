import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { Cartegrise } from '../../models/cartegrise/cartegrise.module';
import { CartegriseService } from '../../_services/cartegrise.service';

@Component({
  selector: 'app-formcg',
  templateUrl: './formcg.component.html',
  styleUrls: ['./formcg.component.css']
})
export class FormcgComponent implements OnInit {
cg : Cartegrise = {
  firstname: '',
  lastname: '',
  cin: '',
  placebirth: '',
  nationality: '',
  city: '',
  postalcode: '',
  address: '',
  phone: '',
  datebirth: '',
  email: ''
};
message = '';

constructor(private cgService: CartegriseService, private router:Router, private route: ActivatedRoute) { }

ngOnInit(): void {
  this.message = '';
  const id = this.route.snapshot.params.id;
}

saveCartegrise(): void {
  this.message = '';
  this.createNewCartegrise();
  
}

private createNewCartegrise() {
  this.cgService.create(this.cg)
    .subscribe(
      response => {
        this.router.navigate([ '/formcg' ]);
        alert("Carte grise created successfully !!");
      },
      error => {
        console.error(error);
        this.message = 'An error occurred while saving carte grise';
      });
    }


}
