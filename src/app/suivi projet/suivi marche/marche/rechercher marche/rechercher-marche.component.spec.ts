import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercherMarcheComponent } from './rechercher-marche.component';

describe('RechercherMarcheComponent', () => {
  let component: RechercherMarcheComponent;
  let fixture: ComponentFixture<RechercherMarcheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RechercherMarcheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RechercherMarcheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
