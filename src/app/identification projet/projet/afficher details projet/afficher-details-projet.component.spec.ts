import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfficherDetailsProjetComponent } from './afficher-details-projet.component';

describe('AfficherDetailsProjetComponent', () => {
  let component: AfficherDetailsProjetComponent;
  let fixture: ComponentFixture<AfficherDetailsProjetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfficherDetailsProjetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfficherDetailsProjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
