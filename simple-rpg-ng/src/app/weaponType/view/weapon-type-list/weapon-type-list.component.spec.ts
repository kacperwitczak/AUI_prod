import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WeaponTypeListComponent } from './weapon-type-list.component';

describe('WeaponTypeListComponent', () => {
  let component: WeaponTypeListComponent;
  let fixture: ComponentFixture<WeaponTypeListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WeaponTypeListComponent]
    });
    fixture = TestBed.createComponent(WeaponTypeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
