import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WeaponTypeAddComponent } from './weapon-type-add.component';

describe('WeaponTypeAddComponent', () => {
  let component: WeaponTypeAddComponent;
  let fixture: ComponentFixture<WeaponTypeAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WeaponTypeAddComponent]
    });
    fixture = TestBed.createComponent(WeaponTypeAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
