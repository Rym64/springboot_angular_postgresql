import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfficherLotsAppelOffreComponent } from './afficher-lots-appel-offre.component';

describe('AfficherLotsAppelOffreComponent', () => {
  let component: AfficherLotsAppelOffreComponent;
  let fixture: ComponentFixture<AfficherLotsAppelOffreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfficherLotsAppelOffreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfficherLotsAppelOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
