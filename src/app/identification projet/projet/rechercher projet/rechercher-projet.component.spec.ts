import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercherProjetComponent } from './rechercher-projet.component';

describe('RechercherProjetComponent', () => {
  let component: RechercherProjetComponent;
  let fixture: ComponentFixture<RechercherProjetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RechercherProjetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RechercherProjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
