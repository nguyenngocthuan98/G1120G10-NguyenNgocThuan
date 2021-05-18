import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Student} from '../../models/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl = 'http://localhost:8080';

  httpOptions: any;

  constructor(private httpClient: HttpClient) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      'Access-Control-Allow-Origin': 'http://localhost:4200/',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS',
      'Access-Control-Allow-Credentials': 'true'
    };
  }

  getAll(): Observable<Student[]> {
    return this.httpClient.get<Student[]>(this.baseUrl + '/students');
  }

  createStudent(student: Student): Observable<any> {
    return this.httpClient.post(this.baseUrl + '/students', student);
  }


  getById(id: number): Observable<Student> {
    return this.httpClient.get<Student>(this.baseUrl + '/students/' + id);
  }

  editStudent(student: Student, id: number): Observable<any> {
    return this.httpClient.put(this.baseUrl + '/students/' + id, student);
  }

  deleteStudent(student: Student, id: number): Observable<any> {
    return this.httpClient.delete(this.baseUrl + '/students/' + id);
  }
}
