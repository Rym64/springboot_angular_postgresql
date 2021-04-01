import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfficherIndicateursComponent } from './afficher-indicateurs.component';

describe('AfficherIndicateursComponent', () => {
  let component: AfficherIndicateursComponent;
  let fixture: ComponentFixture<AfficherIndicateursComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfficherIndicateursComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfficherIndicateursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
