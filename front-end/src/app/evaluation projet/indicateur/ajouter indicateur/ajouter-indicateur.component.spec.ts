import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterIndicateurComponent } from './ajouter-indicateur.component';

describe('AjouterIndicateurComponent', () => {
  let component: AjouterIndicateurComponent;
  let fixture: ComponentFixture<AjouterIndicateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjouterIndicateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjouterIndicateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
