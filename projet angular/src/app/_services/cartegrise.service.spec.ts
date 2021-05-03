import { TestBed } from '@angular/core/testing';

import { CartegriseService } from './cartegrise.service';

describe('CartegriseService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CartegriseService = TestBed.get(CartegriseService);
    expect(service).toBeTruthy();
  });
});
