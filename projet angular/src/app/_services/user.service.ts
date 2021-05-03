import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpHeaders, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
//import { User } from '../models/user.model';

const API_URL = 'http://localhost:8055/api/test/';
const baseUrl = 'http://localhost:8055/api/users/';
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
    return this.http.get(baseUrl+'getall');
  }

  get(id) {
    return this.http.get(`${baseUrl+'findone'}/${id}`);
  }

  create(data) {
    return this.http.post(baseUrl+'add', data);
  }

  update(id, data) {
    return this.http.put(`${baseUrl+'edit'}/${id}`, data);
  }

  delete(id) {
    return this.http.delete(`${baseUrl+'deletebyid'}/${id}`);
  }

  deleteAll() {
    return this.http.delete(baseUrl+'delete');
  }

  findByUsername(username) {
    return this.http.get(`${baseUrl}?username=${username}`);
  }



  //Profile: 
  upload(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST', `${baseUrl+'upload'}`, formData, {
      reportProgress: true,
      responseType: 'json'
    });
    return this.http.request(req);
  }

   getFiles(): Observable<any> {
    return this.http.get(`${baseUrl+'files'}`);
  }
}

