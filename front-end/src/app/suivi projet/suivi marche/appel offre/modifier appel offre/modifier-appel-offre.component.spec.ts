import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifierAppelOffreComponent } from './modifier-appel-offre.component';

describe('ModifierAppelOffreComponent', () => {
  let component: ModifierAppelOffreComponent;
  let fixture: ComponentFixture<ModifierAppelOffreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifierAppelOffreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifierAppelOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
