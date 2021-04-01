import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercherAppelOffreComponent } from './rechercher-appel-offre.component';

describe('RechercherAppelOffreComponent', () => {
  let component: RechercherAppelOffreComponent;
  let fixture: ComponentFixture<RechercherAppelOffreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RechercherAppelOffreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RechercherAppelOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
