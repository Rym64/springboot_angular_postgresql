import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Step4_3Component } from './step4-3.component';

describe('Step4_2Component', () => {
  let component: Step4_3Component;
  let fixture: ComponentFixture<Step4_3Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Step4_3Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Step4_3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
