import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-font-size-editer',
  templateUrl: './font-size-editer.component.html',
  styleUrls: ['./font-size-editer.component.css']
})
export class FontSizeEditerComponent implements OnInit {
  fontSizeOne = 14;
  fontSizeTwo = 20;

  constructor() {
  }

  ngOnInit(): void {
  }

  changeFontSizeOne(fontSizeChangeOne) {
    this.fontSizeOne = fontSizeChangeOne;
  }
}
