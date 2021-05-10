import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-progress-bar',
  templateUrl: './progress-bar.component.html',
  styleUrls: ['./progress-bar.component.css']
})
export class ProgressBarComponent implements OnInit {
  @Input() backgroundColor = '#D9D9D9';
  @Input() progressColor = '#4CAF50';
  @Input() progress = 0;
  @Input() isLoading = false;

  constructor() {
  }

  ngOnInit(): void {
  }

  loading() {
    const interval = setInterval(() => {
      this.progress += 1;
      this.isLoading = true;
      if (this.progress === 100) {
        this.isLoading = false;
        clearInterval(interval);
      }
      if (this.progress > 100) {
        this.progress = 0;
      }
    }, 50);
  }
}
