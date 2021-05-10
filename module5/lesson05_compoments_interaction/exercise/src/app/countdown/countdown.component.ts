import {Component, EventEmitter, Input, OnChanges, OnDestroy, OnInit, Output, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-countdown',
  templateUrl: './countdown.component.html',
  styleUrls: ['./countdown.component.css']
})
export class CountdownComponent implements OnInit, OnChanges, OnDestroy {

  message = '';
  remainingTime: number;
  @Input() seconds = 10;
  @Output() finish = new EventEmitter<boolean>();
  private intervalId = 0;

  ngOnChanges(changes: SimpleChanges) {
    if ('seconds' in changes) {
      let v = changes.seconds.currentValue;
      v = typeof v === 'undefined' ? 10 : v;
      const vFixed = Number(v);
      this.seconds = Number.isNaN(vFixed) ? 10 : vFixed;
    }
  }

  clearTimer() {
    clearInterval(this.intervalId);
  }

  ngOnInit() {
    this.reset();
  }

  ngOnDestroy() {
    this.clearTimer();
  }

  start() {
    this.countDown();
    if (this.remainingTime <= 0) {
      this.remainingTime = this.seconds;
    }
  }

  hold() {
    this.clearTimer();
    this.message = `Hold at ${this.remainingTime}s`;
  }

  reset() {
    this.clearTimer();
    this.remainingTime = this.seconds;
    this.message = 'slap Start button';
  }

  private countDown() {
    this.clearTimer();
    this.intervalId = window.setInterval(() => {
      this.remainingTime -= 1;
      if (this.remainingTime === 0) {
        this.message = 'Time off';
        this.clearTimer();
        this.finish.emit(true);
      } else {
        this.message = `${this.remainingTime}s`;
      }
    }, 1000);
  }
}
