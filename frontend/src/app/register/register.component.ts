import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { UserService } from '../_services/user.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  private roles: string[] = [];

  form: any = {
    username: null,
    firstname: null,
    lastname: null,
    image: null,
    address: null,
    phone: null,
    datebirth: null,
    email: null,
    password: null
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
 // roles? : any[];


  constructor(private authService: AuthService,private userService: UserService,private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
}

  onSubmit(): void {
    const { username, firstname, lastname, image, address, phone, datebirth, email, password } = this.form;

    this.authService.register(username, firstname, lastname, image, address, phone, datebirth, email, password).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        const user = this.tokenStorageService.getUser();
        //this.roles = user.roles;
        this.authService.getAllRoles().subscribe((data : any)=>{
          data.forEach((obj: { selected: boolean; }) => obj.selected = false);
          this.roles = data;
        })
        /*this.userService.getAllRoles().subscribe(
          (data : any)=>{
            data.forEach((obj: { selected: boolean; }) => obj.selected = false);
            this.roles = data;
          }
        ); */ 
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

  /*updateSelectedRoles(index: any) {
    this.roles![index].selected = this.roles![index].selected;
  }*/
}
