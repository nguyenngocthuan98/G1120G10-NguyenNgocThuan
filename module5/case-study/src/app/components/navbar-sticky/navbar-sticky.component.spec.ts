import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarStickyComponent } from './navbar-sticky.component';

describe('NavbarStickyComponent', () => {
  let component: NavbarStickyComponent;
  let fixture: ComponentFixture<NavbarStickyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavbarStickyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarStickyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
