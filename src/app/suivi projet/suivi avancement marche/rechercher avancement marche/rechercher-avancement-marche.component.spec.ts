import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercherAvancementMarcheComponent } from './rechercher-avancement-marche.component';

describe('RechercherAvancementMarcheComponent', () => {
  let component: RechercherAvancementMarcheComponent;
  let fixture: ComponentFixture<RechercherAvancementMarcheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RechercherAvancementMarcheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RechercherAvancementMarcheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
