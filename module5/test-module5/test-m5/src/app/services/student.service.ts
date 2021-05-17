import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Student} from '../../models/student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl = 'http://localhost:3000';

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.httpClient.get(this.baseUrl + '/students');
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
