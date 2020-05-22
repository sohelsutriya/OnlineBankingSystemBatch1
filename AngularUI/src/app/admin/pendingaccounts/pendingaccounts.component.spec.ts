import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingaccountsComponent } from './pendingaccounts.component';

describe('PendingaccountsComponent', () => {
  let component: PendingaccountsComponent;
  let fixture: ComponentFixture<PendingaccountsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PendingaccountsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingaccountsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
