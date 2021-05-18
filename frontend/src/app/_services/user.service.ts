import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';
//import { User } from '../models/user.model';

const API_URL = 'http://localhost:8080/api/test/';
const baseUrl = 'http://localhost:8080/api/';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  /**** Home ****/

  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', { responseType: 'text' });
  }

  getCitoyenBoard(): Observable<any> {
    return this.http.get(API_URL + 'citoyen', { responseType: 'text' });
  }

  getAgentBoard(): Observable<any> {
    return this.http.get(API_URL + 'agent', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', { responseType: 'text' });
  }

 
/**** Crud User ****/
  
  getAll() {
    return this.http.get(baseUrl+'users');
  }

  get(id: string) {
    return this.http.get(`${baseUrl+'users'}/${id}`);
  }

  create(data: User) {
    return this.http.post(baseUrl+'users', data);
  }

  update(id: any, data: User) {
    return this.http.put(`${baseUrl+'users'}/${id}`, data);
  }

  delete(id: any) {
    return this.http.delete(`${baseUrl+'users'}/${id}`);
  }

  deleteAll() {
    return this.http.delete(baseUrl+'users');
  }

  findByUsername(username: string) {
    return this.http.get(`${baseUrl}?username=${username}`);
  }

}

