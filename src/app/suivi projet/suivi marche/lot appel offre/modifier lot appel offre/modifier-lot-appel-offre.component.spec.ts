import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifierLotAppelOffreComponent } from './modifier-lot-appel-offre.component';

describe('ModifierLotAppelOffreComponent', () => {
  let component: ModifierLotAppelOffreComponent;
  let fixture: ComponentFixture<ModifierLotAppelOffreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifierLotAppelOffreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifierLotAppelOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
