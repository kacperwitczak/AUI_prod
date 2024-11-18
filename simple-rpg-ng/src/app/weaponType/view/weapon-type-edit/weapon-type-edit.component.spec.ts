import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WeaponTypeEditComponent } from './weapon-type-edit.component';

describe('WeaponTypeEditComponent', () => {
  let component: WeaponTypeEditComponent;
  let fixture: ComponentFixture<WeaponTypeEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WeaponTypeEditComponent]
    });
    fixture = TestBed.createComponent(WeaponTypeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
