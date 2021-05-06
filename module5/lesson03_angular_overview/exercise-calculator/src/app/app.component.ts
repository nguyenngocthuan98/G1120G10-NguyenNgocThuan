import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public title = 'Calculator';
  public result: number;

  constructor() {
  }

  ngOnInit(): void {
  }

  public calculator(firstNum: string, secondNum: string, operator: string): number {
    let fNum: number = parseInt(firstNum);
    let sNum: number = parseInt(secondNum);

    switch (operator) {
      case '+':
        return this.result = fNum + sNum;
      case '-':
        return this.result = fNum - sNum;
      case '*':
        return this.result = fNum * sNum;
      case '/':
        if (sNum === 0) {
          return this.result = 'You can\'t divide with 0';
        }
        return this.result = fNum / sNum;
    }
  }
}
