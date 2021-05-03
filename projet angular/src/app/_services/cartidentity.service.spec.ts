import { TestBed } from '@angular/core/testing';

import { CartidentityService } from './cartidentity.service';

describe('CartidentityService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CartidentityService = TestBed.get(CartidentityService);
    expect(service).toBeTruthy();
  });
});
