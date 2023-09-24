import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddBulkCustomerComponent } from './add-bulk-customer.component';

describe('AddBulkCustomerComponent', () => {
  let component: AddBulkCustomerComponent;
  let fixture: ComponentFixture<AddBulkCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddBulkCustomerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddBulkCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
