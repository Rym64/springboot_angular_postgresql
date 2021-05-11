import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsFactureComponent } from './details-facture.component';

describe('DetailsFactureComponent', () => {
  let component: DetailsFactureComponent;
  let fixture: ComponentFixture<DetailsFactureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsFactureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsFactureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
