import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormcgComponent } from './formcg.component';

describe('FormcgComponent', () => {
  let component: FormcgComponent;
  let fixture: ComponentFixture<FormcgComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormcgComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormcgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
