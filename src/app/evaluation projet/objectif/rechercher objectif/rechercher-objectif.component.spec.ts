import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercherObjectifComponent } from './rechercher-objectif.component';

describe('RechercherObjectifComponent', () => {
  let component: RechercherObjectifComponent;
  let fixture: ComponentFixture<RechercherObjectifComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RechercherObjectifComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RechercherObjectifComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
