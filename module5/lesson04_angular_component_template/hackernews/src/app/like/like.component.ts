import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-like',
  templateUrl: './like.component.html',
  styleUrls: ['./like.component.css']
})
export class LikeComponent implements OnInit {
  public likeCount = 0;

  constructor() {
  }

  ngOnInit(): void {
  }

  like() {
    this.likeCount++;
  }
}
