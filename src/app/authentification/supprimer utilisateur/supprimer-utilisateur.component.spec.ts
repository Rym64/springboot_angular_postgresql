import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupprimerUtilisateurComponent } from './supprimer-utilisateur.component';

describe('SupprimerUtilisateurComponent', () => {
  let component: SupprimerUtilisateurComponent;
  let fixture: ComponentFixture<SupprimerUtilisateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupprimerUtilisateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupprimerUtilisateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
