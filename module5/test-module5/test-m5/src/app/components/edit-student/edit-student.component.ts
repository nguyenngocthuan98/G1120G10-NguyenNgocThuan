import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {StudentService} from '../../services/student.service';

@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.css']
})
export class EditStudentComponent implements OnInit {
  formEdit: FormGroup;
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
      this.formEdit.patchValue(data);
    });
  }

  initForm() {
    this.formEdit = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z ]+$')]),
      nameGroup: new FormControl('', Validators.required),
      topic: new FormControl(''),
      teacher: new FormControl('', Validators.required),
      email: new FormControl('', [Validators.required, Validators.email]),
      phone: new FormControl('', [Validators.required, Validators.pattern('^[0-9]{10,12}$')]),
    });
  }

  editStudent() {
    if (this.formEdit.valid) {
      this.studentService.editStudent(this.formEdit.value, this.id).subscribe(data => {
        this.router.navigateByUrl('/list-student');
      });
    }
  }
}
