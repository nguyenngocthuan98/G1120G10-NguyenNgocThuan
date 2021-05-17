import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {StudentService} from '../../services/student.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit {
  formCreate: FormGroup;

  constructor(private studentService: StudentService, private router: Router) {
  }

  ngOnInit(): void {
    this.initForm();
  }

  initForm() {
    this.formCreate = new FormGroup({
      name: new FormControl('', Validators.required),
      nameGroup: new FormControl('', Validators.required),
      topic: new FormControl('', Validators.required),
      teacher: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      phone: new FormControl('', Validators.required),
    });
  }

  createStudent() {
    if (this.formCreate.valid) {
      this.studentService.createStudent(this.formCreate.value).subscribe(data => {
        this.router.navigateByUrl('/list-student');
      });
    }
  }
}
