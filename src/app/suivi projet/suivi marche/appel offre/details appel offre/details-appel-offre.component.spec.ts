import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsAppelOffreComponent } from './details-appel-offre.component';

describe('DetailsAppelOffreComponent', () => {
  let component: DetailsAppelOffreComponent;
  let fixture: ComponentFixture<DetailsAppelOffreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsAppelOffreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsAppelOffreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
