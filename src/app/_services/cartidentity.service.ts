import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8055/api/';

@Injectable({
  providedIn: 'root'
}) 

export class CartidentityService {

  constructor(private http: HttpClient) { }

 
  getAll() {
    return this.http.get(baseUrl+'demandecins');
  }

  get(id) {
    return this.http.get(`${baseUrl+'demandecins'}/${id}`);
  }

  create(data) {
    return this.http.post(baseUrl+'demandecins', data);
  }

  update(id, data) {
    return this.http.put(`${baseUrl+'demandecins'}/${id}`, data);
  }

  delete(id) {
    return this.http.delete(`${baseUrl+'demandecins'}/${id}`);
  }

  deleteAll() {
    return this.http.delete(baseUrl+'demandecins');
  }

  findByFirstname(firstname) {
    return this.http.get(`${baseUrl}?firstname=${firstname}`);
  }

}


