import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable  } from 'rxjs';
import { User } from '../models/user.model';

const baseUrl = 'http://localhost:8080/api/users';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  constructor(private http: HttpClient) {
  }

  list(): Observable<any> {
    return this.http.get(baseUrl);
  }

  get(id: string): Observable<any> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  create(data: User): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(id: string, data: User): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id: string): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  findByFirstname(firstname: string): Observable<any> {
    return this.http.get(`${baseUrl}?firstname=${firstname}`);
  }
}
