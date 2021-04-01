import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupprimerObjectifComponent } from './supprimer-objectif.component';

describe('SupprimerObjectifComponent', () => {
  let component: SupprimerObjectifComponent;
  let fixture: ComponentFixture<SupprimerObjectifComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupprimerObjectifComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupprimerObjectifComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
