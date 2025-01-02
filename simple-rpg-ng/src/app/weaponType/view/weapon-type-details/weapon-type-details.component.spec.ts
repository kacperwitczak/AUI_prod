import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WeaponTypeDetailsComponent } from './weapon-type-details.component';

describe('WeaponTypeDetailsComponent', () => {
  let component: WeaponTypeDetailsComponent;
  let fixture: ComponentFixture<WeaponTypeDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WeaponTypeDetailsComponent]
    });
    fixture = TestBed.createComponent(WeaponTypeDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
