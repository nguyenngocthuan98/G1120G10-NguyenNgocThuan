import {Component} from '@angular/core';
import {Account} from './account';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'register-login';

  public accounts: Account[] = [
    {email: 'admin@localhost.com', password: 'admin', age: 1, country: 'US', gender: 0, phone: '+84123456789'},
    {email: 'guest@localhost.com', password: 'guest', age: 1, country: 'US', gender: 1, phone: '+84123456789'},
    {email: 'test@localhost.com', password: 'test', age: 1, country: 'US', gender: 2, phone: '+84123456789'}
  ];
}
