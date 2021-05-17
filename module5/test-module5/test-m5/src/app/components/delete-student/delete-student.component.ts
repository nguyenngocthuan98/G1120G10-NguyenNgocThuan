import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {StudentService} from '../../services/student.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-delete-student',
  templateUrl: './delete-student.component.html',
  styleUrls: ['./delete-student.component.css']
})
export class DeleteStudentComponent implements OnInit {
  formDelete: FormGroup;
  private id = 0;

  constructor(
    private studentService: StudentService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params.id;
    this.initForm();
    this.studentService.getById(this.id).subscribe(data => {
      this.formDelete.patchValue(data);
    });
  }

  initForm() {
    this.formDelete = new FormGroup({
      name: new FormControl(''),
      id: new FormControl(''),
    });
  }

  deleteStudent() {
    this.studentService.deleteStudent(this.formDelete.value, this.id).subscribe(data => {
      this.router.navigateByUrl('/list-student');
    });
  }
}
