import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsFinancementEtrangerComponent } from './details-financement-etranger.component';

describe('DetailsFinancementEtrangerComponent', () => {
  let component: DetailsFinancementEtrangerComponent;
  let fixture: ComponentFixture<DetailsFinancementEtrangerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsFinancementEtrangerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsFinancementEtrangerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
