import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsProjetComponent } from './details-projet.component';

describe('DetailsProjetComponent', () => {
  let component: DetailsProjetComponent;
  let fixture: ComponentFixture<DetailsProjetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsProjetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsProjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
