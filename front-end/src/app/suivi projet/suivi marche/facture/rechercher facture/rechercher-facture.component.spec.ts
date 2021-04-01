import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercherFactureComponent } from './rechercher-facture.component';

describe('RechercherFactureComponent', () => {
  let component: RechercherFactureComponent;
  let fixture: ComponentFixture<RechercherFactureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RechercherFactureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RechercherFactureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
