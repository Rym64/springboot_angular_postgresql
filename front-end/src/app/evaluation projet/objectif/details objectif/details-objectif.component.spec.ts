import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsObjectifComponent } from './details-objectif.component';

describe('DetailsObjectifComponent', () => {
  let component: DetailsObjectifComponent;
  let fixture: ComponentFixture<DetailsObjectifComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsObjectifComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsObjectifComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
