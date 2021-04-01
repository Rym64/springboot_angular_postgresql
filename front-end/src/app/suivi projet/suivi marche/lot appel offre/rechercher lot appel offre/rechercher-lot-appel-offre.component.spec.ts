import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercherLotAppelOffreComponent } from './rechercher-lot-appel-offre.component';

describe('RechercherLotAppelOffreComponent', () => {
  let component: RechercherLotAppelOffreComponent;
  let fixture: ComponentFixture<RechercherLotAppelOffreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RechercherLotAppelOffreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RechercherLotAppelOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
