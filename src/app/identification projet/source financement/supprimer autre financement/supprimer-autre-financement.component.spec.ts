import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SupprimerAutreFinancementComponent } from './supprimer-autre-financement.component';

describe('SupprimerAutreFinancementComponent', () => {
  let component: SupprimerAutreFinancementComponent;
  let fixture: ComponentFixture<SupprimerAutreFinancementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SupprimerAutreFinancementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SupprimerAutreFinancementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
