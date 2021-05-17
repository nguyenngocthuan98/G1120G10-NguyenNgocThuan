import {Injectable} from '@angular/core';
import {Product} from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor() {
  }

  public listOrigin: string[] = ['VietNam', 'England', 'America', 'China'];
  public listProducts: Product[] = [
    {
      _idProduct: 1,
      _name: 'VF E34',
      _date: new Date('2021-09-05'),
      _quantity: 35, _price: 690,
      _origin: this.listOrigin[0]
    },
    {
      _idProduct: 2,
      _name: 'VF President',
      _date: new Date('2020-12-12'),
      _quantity: 0,
      _price: 4600,
      _origin: this.listOrigin[0]
    },
    {
      _idProduct: 3,
      _name: 'VF LUX A2.0',
      _date: new Date('2020-01-05'),
      _quantity: 86,
      _price: 1358,
      _origin: this.listOrigin[0]
    },
    {
      _idProduct: 4,
      _name: 'VF LUX SA2.0',
      _date: new Date('2020-05-05'),
      _quantity: 86,
      _price: 1552,
      _origin: this.listOrigin[0]
    },
    {
      _idProduct: 5,
      _name: 'Range Rover LWB',
      _date: new Date('2020-02-10'),
      _quantity: 5,
      _price: 10760,
      _origin: this.listOrigin[1]
    },
    {
      _idProduct: 6,
      _name: 'Ranger Raptor',
      _date: new Date('2020-05-10'),
      _quantity: 242,
      _price: 1202,
      _origin: this.listOrigin[2]
    },
    {
      _idProduct: 7,
      _name: 'Mini J-Cooper LCI',
      _date: new Date('2021-01-05'),
      _quantity: 2,
      _price: 2969,
      _origin: this.listOrigin[1]
    },
    {
      _idProduct: 8,
      _name: 'MG HS-Trophy',
      _date: new Date('2020-04-25'),
      _quantity: 100,
      _price: 949,
      _origin: this.listOrigin[3]
    },
    {
      _idProduct: 9,
      _name: 'MG ZS-LUX+',
      _date: new Date('2020-04-15'),
      _quantity: 100,
      _price: 619,
      _origin: this.listOrigin[3]
    },
  ];
}
