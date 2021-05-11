import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupprimerIndicateurComponent } from './supprimer-indicateur.component';

describe('SupprimerIndicateurComponent', () => {
  let component: SupprimerIndicateurComponent;
  let fixture: ComponentFixture<SupprimerIndicateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupprimerIndicateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupprimerIndicateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
