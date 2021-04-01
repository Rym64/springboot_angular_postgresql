import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfficherAppelsOffreComponent } from './afficher-appels-offre.component';

describe('AfficherAppelsOffreComponent', () => {
  let component: AfficherAppelsOffreComponent;
  let fixture: ComponentFixture<AfficherAppelsOffreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfficherAppelsOffreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfficherAppelsOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
