import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterLotAppelOffreComponent } from './ajouter-lot-appel-offre.component';

describe('AjouterLotAppelOffreComponent', () => {
  let component: AjouterLotAppelOffreComponent;
  let fixture: ComponentFixture<AjouterLotAppelOffreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjouterLotAppelOffreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjouterLotAppelOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
