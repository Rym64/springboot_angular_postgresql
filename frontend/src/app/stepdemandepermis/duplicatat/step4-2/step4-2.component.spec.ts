import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Step4_2Component } from './step4-2.component';

describe('Step4_2Component', () => {
  let component: Step4_2Component;
  let fixture: ComponentFixture<Step4_2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Step4_2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Step4_2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
