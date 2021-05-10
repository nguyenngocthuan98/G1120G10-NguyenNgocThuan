import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BottombarNotificationComponent } from './bottombar-notification.component';

describe('BottombarNotificationComponent', () => {
  let component: BottombarNotificationComponent;
  let fixture: ComponentFixture<BottombarNotificationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BottombarNotificationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BottombarNotificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
