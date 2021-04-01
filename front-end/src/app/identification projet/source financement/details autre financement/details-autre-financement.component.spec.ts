import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsAutreFinancementComponent } from './details-autre-financement.component';

describe('DetailsAutreFinancementComponent', () => {
  let component: DetailsAutreFinancementComponent;
  let fixture: ComponentFixture<DetailsAutreFinancementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsAutreFinancementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsAutreFinancementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
