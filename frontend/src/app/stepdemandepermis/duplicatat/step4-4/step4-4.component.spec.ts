import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Step4_4Component } from './step4-4.component';

describe('Step4_4Component', () => {
  let component: Step4_4Component;
  let fixture: ComponentFixture<Step4_4Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Step4_4Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Step4_4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
