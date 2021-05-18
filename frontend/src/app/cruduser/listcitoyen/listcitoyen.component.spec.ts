import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListcitoyenComponent } from './listcitoyen.component';

describe('ListcitoyenComponent', () => {
  let component: ListcitoyenComponent;
  let fixture: ComponentFixture<ListcitoyenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListcitoyenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListcitoyenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
