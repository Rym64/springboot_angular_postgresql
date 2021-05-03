import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormCINComponent } from './form-cin.component';

describe('FormCINComponent', () => {
  let component: FormCINComponent;
  let fixture: ComponentFixture<FormCINComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormCINComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormCINComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
