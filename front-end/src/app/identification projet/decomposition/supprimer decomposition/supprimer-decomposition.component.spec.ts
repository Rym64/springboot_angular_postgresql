import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupprimerDecompositionComponent } from './supprimer-decomposition.component';

describe('SupprimerDecompositionComponent', () => {
  let component: SupprimerDecompositionComponent;
  let fixture: ComponentFixture<SupprimerDecompositionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupprimerDecompositionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupprimerDecompositionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
