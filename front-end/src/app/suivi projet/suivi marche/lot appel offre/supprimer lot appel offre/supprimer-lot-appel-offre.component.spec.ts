import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupprimerLotAppelOffreComponent } from './supprimer-lot-appel-offre.component';

describe('SupprimerLotAppelOffreComponent', () => {
  let component: SupprimerLotAppelOffreComponent;
  let fixture: ComponentFixture<SupprimerLotAppelOffreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupprimerLotAppelOffreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupprimerLotAppelOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
