import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ProductListComponent} from './product/product-list/product-list.component';
import {ProductAddComponent} from './product/product-add/product-add.component';
import {ProductEditComponent} from './product/product-edit/product-edit.component';
import {ProductDetailComponent} from './product/product-detail/product-detail.component';


const routes: Routes = [
  {path: 'listProduct', component: ProductListComponent},
  {path: 'listProduct/addProduct', component: ProductAddComponent},
  {path: 'listProduct/editProduct/:id', component: ProductEditComponent},
  {path: 'listProduct/detailProduct/:id', component: ProductDetailComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
