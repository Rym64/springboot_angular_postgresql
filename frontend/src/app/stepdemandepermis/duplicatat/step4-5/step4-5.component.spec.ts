import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Step4_5Component } from './step4-5.component';

describe('Step4_5Component', () => {
  let component: Step4_5Component;
  let fixture: ComponentFixture<Step4_5Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Step4_5Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Step4_5Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
