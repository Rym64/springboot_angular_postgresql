import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterFinancementPublicComponent } from './ajouter-financement-public.component';

describe('AjouterFinancementPublicComponent', () => {
  let component: AjouterFinancementPublicComponent;
  let fixture: ComponentFixture<AjouterFinancementPublicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjouterFinancementPublicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjouterFinancementPublicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
