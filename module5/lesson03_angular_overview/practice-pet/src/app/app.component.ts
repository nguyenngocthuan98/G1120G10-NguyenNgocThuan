import { Component } from '@angular/core';
import {Pet} from './pet';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'practice-pet';
  pet: Pet = {
    name: 'big dog',
    image: 'http://yourdost-blog-images.s3-ap-southeast-1.amazonaws.com/wp-content/uploads/2016/01/03165939/Dogs.jpg'
  };
  constructor() { }

  ngOnInit() {
  }
}
