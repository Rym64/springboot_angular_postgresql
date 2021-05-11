import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AfficherObjectifsComponent } from './afficher-objectifs.component';

describe('AfficherObjectifsComponent', () => {
  let component: AfficherObjectifsComponent;
  let fixture: ComponentFixture<AfficherObjectifsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AfficherObjectifsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AfficherObjectifsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
