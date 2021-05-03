import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { Cartidentity } from '../../models/cartidentity/cartidentity.module';
import { CartidentityService } from '../../_services/cartidentity.service';

@Component({
  selector: 'app-form-cin',
  templateUrl: './form-cin.component.html',
  styleUrls: ['./form-cin.component.css']
})
export class FormCINComponent implements OnInit {

cin : Cartidentity = {
  firstname: '',
  lastname: '',
  placebirth: '',
  nationality: '',
  city: '',
  postalcode: '',
  address: '',
  phone: '',
  datebirth: '',
  email: '',
  mothername:'',
  fathername:'',
  job:''
};
message = '';

constructor(private cinService: CartidentityService, private router:Router, private route: ActivatedRoute) { }

ngOnInit(): void {
  this.message = '';
  const id = this.route.snapshot.params.id;
}

saveCartidentity(): void {
  this.message = '';
  this.createNewCartidentity();
  
}

private createNewCartidentity() {
  this.cinService.create(this.cin)
    .subscribe(
      response => {
        this.router.navigate([ '/formcin' ]);
        alert("Cart identity created successfully !!");
      },
      error => {
        console.error(error);
        this.message = 'An error occurred while saving cart identity';
      });
}


}
