import { Component, OnInit } from '@angular/core';
import { WeaponTypeForm } from '../../model/weaponType-form';
import { WeaponTypeService } from '../../service/weaponType.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-weapon-type-add',
  templateUrl: './weapon-type-add.component.html',
  styleUrls: ['./weapon-type-add.component.css']
})
export class WeaponTypeAddComponent implements OnInit {
  weaponType: WeaponTypeForm = { description: '', category: '' };

  constructor(
    private weaponTypeService: WeaponTypeService,
    private router: Router
  ) {}

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.weaponTypeService.postWeaponType(this.weaponType)
      .subscribe(() => {
        this.router.navigate(['/weapontypes']);
      });
  }
}
