import {Component, OnInit} from '@angular/core';
import {Student} from '../../../models/student';
import {StudentService} from '../../services/student.service';

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.css']
})
export class ListStudentComponent implements OnInit {
  listStudent: Student[] = [];

  constructor(private studentService: StudentService) {
  }

  ngOnInit(): void {
    this.initListStudent();
  }

  initListStudent() {
    this.studentService.getAll().subscribe(data => {
      this.listStudent = data;
    });
  }
}
