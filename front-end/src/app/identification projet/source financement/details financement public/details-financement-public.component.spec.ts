import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsFinancementPublicComponent } from './details-financement-public.component';

describe('DetailsFinancementPublicComponent', () => {
  let component: DetailsFinancementPublicComponent;
  let fixture: ComponentFixture<DetailsFinancementPublicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsFinancementPublicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsFinancementPublicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
