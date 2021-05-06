import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListcgComponent } from './listcg.component';

describe('ListcgComponent', () => {
  let component: ListcgComponent;
  let fixture: ComponentFixture<ListcgComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListcgComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListcgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
