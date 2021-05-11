import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsMarcheComponent } from './details-marche.component';

describe('DetailsMarcheComponent', () => {
  let component: DetailsMarcheComponent;
  let fixture: ComponentFixture<DetailsMarcheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsMarcheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsMarcheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
