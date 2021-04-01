import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsLotAppelOffreComponent } from './details-lot-appel-offre.component';

describe('DetailsLotAppelOffreComponent', () => {
  let component: DetailsLotAppelOffreComponent;
  let fixture: ComponentFixture<DetailsLotAppelOffreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsLotAppelOffreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsLotAppelOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
