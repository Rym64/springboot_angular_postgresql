import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercherFinancementEtrangerComponent } from './rechercher-financement-etranger.component';

describe('RechercherFinancementEtrangerComponent', () => {
  let component: RechercherFinancementEtrangerComponent;
  let fixture: ComponentFixture<RechercherFinancementEtrangerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RechercherFinancementEtrangerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RechercherFinancementEtrangerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
