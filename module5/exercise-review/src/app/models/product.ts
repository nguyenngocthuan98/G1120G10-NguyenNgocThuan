export class Product {
  private _name: string;
  private _price: number;
  private _date: Date;
  private _origin: string;
  private _status: number;

  constructor(name: string, price: number, date: Date, origin: string, status: number) {
    this._name = name;
    this._price = price;
    this._date = date;
    this._origin = origin;
    this._status = status;
  }


  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get price(): number {
    return this._price;
  }

  set price(value: number) {
    this._price = value;
  }

  get date(): Date {
    return this._date;
  }

  set date(value: Date) {
    this._date = value;
  }

  get origin(): string {
    return this._origin;
  }

  set origin(value: string) {
    this._origin = value;
  }

  get status(): number {
    return this._status;
  }

  set status(value: number) {
    this._status = value;
  }
}
