import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupprimerMarcheComponent } from './supprimer-marche.component';

describe('SupprimerMarcheComponent', () => {
  let component: SupprimerMarcheComponent;
  let fixture: ComponentFixture<SupprimerMarcheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupprimerMarcheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupprimerMarcheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
