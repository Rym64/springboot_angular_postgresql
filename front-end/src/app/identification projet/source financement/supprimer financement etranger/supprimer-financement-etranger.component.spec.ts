import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupprimerFinancementEtrangerComponent } from './supprimer-financement-etranger.component';

describe('SupprimerFinancementEtrangerComponent', () => {
  let component: SupprimerFinancementEtrangerComponent;
  let fixture: ComponentFixture<SupprimerFinancementEtrangerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupprimerFinancementEtrangerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupprimerFinancementEtrangerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
