import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercherIndicateurComponent } from './rechercher-indicateur.component';

describe('RechercherIndicateurComponent', () => {
  let component: RechercherIndicateurComponent;
  let fixture: ComponentFixture<RechercherIndicateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RechercherIndicateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RechercherIndicateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
