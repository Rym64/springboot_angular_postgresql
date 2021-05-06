import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCINComponent } from './list-cin.component';

describe('ListCINComponent', () => {
  let component: ListCINComponent;
  let fixture: ComponentFixture<ListCINComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListCINComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListCINComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
