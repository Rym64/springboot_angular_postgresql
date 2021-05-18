import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandepermisComponent } from './demandepermis.component';

describe('DemandepermisComponent', () => {
  let component: DemandepermisComponent;
  let fixture: ComponentFixture<DemandepermisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DemandepermisComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DemandepermisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
