import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WeaponAddComponent } from './weapon-add.component';

describe('WeaponAddComponent', () => {
  let component: WeaponAddComponent;
  let fixture: ComponentFixture<WeaponAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WeaponAddComponent]
    });
    fixture = TestBed.createComponent(WeaponAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
