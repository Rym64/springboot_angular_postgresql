import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupprimerFinancementPublicComponent } from './supprimer-financement-public.component';

describe('SupprimerFinancementPublicComponent', () => {
  let component: SupprimerFinancementPublicComponent;
  let fixture: ComponentFixture<SupprimerFinancementPublicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupprimerFinancementPublicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupprimerFinancementPublicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
