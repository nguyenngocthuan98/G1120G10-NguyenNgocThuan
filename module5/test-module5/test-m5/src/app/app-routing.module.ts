import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListStudentComponent} from './components/list-student/list-student.component';
import {CreateStudentComponent} from './components/create-student/create-student.component';
import {EditStudentComponent} from './components/edit-student/edit-student.component';
import {DeleteStudentComponent} from './components/delete-student/delete-student.component';


const routes: Routes = [
  {path: 'list-student', component: ListStudentComponent},
  {path: 'create-student', component: CreateStudentComponent},
  {path: 'edit-student/:id', component: EditStudentComponent},
  {path: 'delete-student/:id', component: DeleteStudentComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
