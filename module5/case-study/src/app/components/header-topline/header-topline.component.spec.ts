import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderToplineComponent } from './header-topline.component';

describe('HeaderToplineComponent', () => {
  let component: HeaderToplineComponent;
  let fixture: ComponentFixture<HeaderToplineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderToplineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderToplineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
