import {Component, OnInit} from '@angular/core';
import {Product} from '../../models/product';
import {ProductService} from '../product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  public list: Product[] = [];

  constructor(private _productService: ProductService) {
  }

  ngOnInit(): void {
    this.list = this._productService.listProducts;
  }

}
