import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifierIndicateurComponent } from './modifier-indicateur.component';

describe('ModifierIndicateurComponent', () => {
  let component: ModifierIndicateurComponent;
  let fixture: ComponentFixture<ModifierIndicateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifierIndicateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifierIndicateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
