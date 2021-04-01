import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifierObjectifComponent } from './modifier-objectif.component';

describe('ModifierObjectifComponent', () => {
  let component: ModifierObjectifComponent;
  let fixture: ComponentFixture<ModifierObjectifComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifierObjectifComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifierObjectifComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
