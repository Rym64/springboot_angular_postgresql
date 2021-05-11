import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfficherDecompositionsComponent } from './afficher-decompositions.component';

describe('DecompositionComponent', () => {
  let component: AfficherDecompositionsComponent;
  let fixture: ComponentFixture<AfficherDecompositionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfficherDecompositionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfficherDecompositionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
