import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercherDecompositionComponent } from './rechercher-decomposition.component';

describe('RechercherDecompositionComponent', () => {
  let component: RechercherDecompositionComponent;
  let fixture: ComponentFixture<RechercherDecompositionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RechercherDecompositionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RechercherDecompositionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
