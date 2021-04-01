import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsDecompositionComponent } from './details-decomposition.component';

describe('DetailsDecompositionComponent', () => {
  let component: DetailsDecompositionComponent;
  let fixture: ComponentFixture<DetailsDecompositionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsDecompositionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsDecompositionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
