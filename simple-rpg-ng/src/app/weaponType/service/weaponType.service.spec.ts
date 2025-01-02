import { TestBed } from '@angular/core/testing';

import { WeaponTypeService } from './weaponType.service';

describe('ProfessionService', () => {
  let service: WeaponTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WeaponTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
