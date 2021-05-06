import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8055/api/demandecgs/';

@Injectable({
  providedIn: 'root'
})

export class CartegriseService {

  constructor(private http: HttpClient) { }

 
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

  findByFirstname(firstname) {
    return this.http.get(`${baseUrl}?firstname=${firstname}`);
  }

}


