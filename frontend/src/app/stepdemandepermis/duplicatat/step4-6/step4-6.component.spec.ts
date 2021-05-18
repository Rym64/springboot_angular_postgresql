import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Step4_6Component } from './step4-6.component';

describe('Step4_6Component', () => {
  let component: Step4_6Component;
  let fixture: ComponentFixture<Step4_6Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Step4_6Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Step4_6Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
