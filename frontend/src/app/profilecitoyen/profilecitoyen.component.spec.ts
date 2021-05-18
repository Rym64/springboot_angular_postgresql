import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilecitoyenComponent } from './profilecitoyen.component';

describe('ProfilecitoyenComponent', () => {
  let component: ProfilecitoyenComponent;
  let fixture: ComponentFixture<ProfilecitoyenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfilecitoyenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfilecitoyenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
