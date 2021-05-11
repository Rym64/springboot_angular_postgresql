import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsIndicateurComponent } from './details-indicateur.component';

describe('DetailsIndicateurComponent', () => {
  let component: DetailsIndicateurComponent;
  let fixture: ComponentFixture<DetailsIndicateurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsIndicateurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsIndicateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
