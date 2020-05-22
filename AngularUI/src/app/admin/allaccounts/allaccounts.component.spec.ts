import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllaccountsComponent } from './allaccounts.component';

describe('AllaccountsComponent', () => {
  let component: AllaccountsComponent;
  let fixture: ComponentFixture<AllaccountsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllaccountsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllaccountsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
