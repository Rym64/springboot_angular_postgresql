import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercherAutreFinancementComponent } from './rechercher-autre-financement.component';

describe('RechercherAutreFinancementComponent', () => {
  let component: RechercherAutreFinancementComponent;
  let fixture: ComponentFixture<RechercherAutreFinancementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RechercherAutreFinancementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RechercherAutreFinancementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
