import { Component, OnInit } from '@angular/core';
import {Product} from '../../models/product';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  public product: Product | undefined;
  public products: Product[] = [
    new Product("iPhoneA", 30000000, new Date('2021-05-05'), 'USA', 100),
    new Product("iPhoneB", 30000000, new Date('2021-05-05'), 'USA', 100),
    new Product("iPhoneC", 30000000, new Date('2021-05-05'), 'USA', 100),
    new Product("iPhoneD", 30000000, new Date('2021-05-05'), 'USA', 100)
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
