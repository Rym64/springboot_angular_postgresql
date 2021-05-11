import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterAppelOffreComponent } from './ajouter-appel-offre.component';

describe('AjouterAppelOffreComponent', () => {
  let component: AjouterAppelOffreComponent;
  let fixture: ComponentFixture<AjouterAppelOffreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjouterAppelOffreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjouterAppelOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
