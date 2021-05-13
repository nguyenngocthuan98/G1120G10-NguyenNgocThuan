import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ProductsComponent } from './components/products/products.component';
import {RouterModule} from '@angular/router';
import { ProductListComponent } from './product-list/product-list.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    ProductListComponent
  ],
    imports: [
        BrowserModule,
        RouterModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
