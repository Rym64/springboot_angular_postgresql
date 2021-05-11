import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterObjectifComponent } from './ajouter-objectif.component';

describe('AjouterObjectifComponent', () => {
  let component: AjouterObjectifComponent;
  let fixture: ComponentFixture<AjouterObjectifComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjouterObjectifComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjouterObjectifComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
