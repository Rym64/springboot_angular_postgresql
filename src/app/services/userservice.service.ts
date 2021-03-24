import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { User } from '../models/user.model';


@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  constructor( private http:HttpClient ) { }

  public login(email:string,pwd:string){
      const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(email + ':' + pwd) });
      return this.http.get("http://localhost:8096/api/v1/users",{headers,responseType: 'text' as 'json'})
    }

    public getUsers() {
          //let email='javatechie'
          //let pwd='jt143'
          //const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(email + ':' + pwd) });
         return  this.http.get("http://localhost:8096/api/v1/users");
        }
}
