import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupprimerAppelOffreComponent } from './supprimer-appel-offre.component';

describe('SupprimerAppelOffreComponent', () => {
  let component: SupprimerAppelOffreComponent;
  let fixture: ComponentFixture<SupprimerAppelOffreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupprimerAppelOffreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupprimerAppelOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
