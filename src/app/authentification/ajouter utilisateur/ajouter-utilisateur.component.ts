import { Component, OnInit } from '@angular/core';
import { User } from '../../shared/modele/user.model';
import { WebService } from '../../shared/sevices/web.service';
import { FormBuilder, Validators }
from '@angular/forms';
import { EnumGouvernorat } from 'src/app/shared/modele/enumGouvernorat.model';
import {
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-ajouter-utilisateur',
  templateUrl: './ajouter-utilisateur.component.html',
  styleUrls: ['./ajouter-utilisateur.component.scss'],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'ar-TN'},
    {provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS]},
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},],
})



export class AjouterUtilisateurComponent implements OnInit {

 
  user: User=new User();
  submitted = false;
  userFile ;
  public imagePath;
  imgURL: any;
  public message: string;
  gouvernorat = EnumGouvernorat;
  gouvernoratKeys=[];



  constructor(private webService: WebService,public fb: FormBuilder,private router: Router) { 
      this.gouvernoratKeys=Object.keys(this.gouvernorat);
    }



  ngOnInit() {
    this.infoForm();
  }



  infoForm() {
    this.webService.dataForm = this.fb.group({
        name: ['', [Validators.required]],
        last_name: ['', [Validators.required]],
        username: ['', [Validators.required]],
        email: ['', [Validators.required]],
        password: ['', [Validators.required]],
        date_naissance: ['', [Validators.required]],
        adresse: ['', [Validators.required]],
        sexe: ['', [Validators.required]],  
      });
    }



  newUser(): void {
    this.submitted = false;
    this.user = new User();
  }



  addUser() {
  const formData = new  FormData();
  const user = this.webService.dataForm.value;
  formData.append('user',JSON.stringify(user));
  formData.append('file',this.userFile);
    this.webService.createUser("ajouterUtilisateur", formData).subscribe(data => console.log(data), error => console.log(error));
    this.gotoList();
  }


  onSubmit() {
    this.submitted = true;
    this.addUser();    
  }


  gotoList() {
    this.router.navigate(['/afficherUtilisateurs']);
    window.location.href="/afficherUtilisateurs"; 
  }


  onSelectFile(event) {
    if (event.target.files.length > 0){
    const file = event.target.files[0];
    this.userFile = file; 
    var mimeType = event.target.files[0].type;
    if (mimeType.match(/image\/*/) == null) {
      this.message = "Only images are supported.";
      return;}
    var reader = new FileReader();
    this.imagePath = file;
    reader.readAsDataURL(file); 
    reader.onload = (_event) => { 
      this.imgURL = reader.result; 
    }}  
  }


}
