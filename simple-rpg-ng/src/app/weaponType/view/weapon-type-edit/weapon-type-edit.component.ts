import { Component, OnInit } from '@angular/core';
import { WeaponTypeForm } from '../../model/weaponType-form';
import { WeaponTypeService } from '../../service/weaponType.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-weapon-type-edit',
  templateUrl: './weapon-type-edit.component.html',
  styleUrls: ['./weapon-type-edit.component.css']
})

export class WeaponTypeEditComponent implements OnInit {
  uuid: string | undefined;
  weaponType: WeaponTypeForm | undefined;
  original: WeaponTypeForm | undefined;
  weaponTypes: WeaponTypeForm | undefined;

  constructor(
    private weaponTypeService: WeaponTypeService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.weaponTypeService.getWeaponType(params['id'])
        .subscribe(weapon => {
          this.uuid = weapon.id;
          this.weaponType = {
            description: weapon.description,
            category: weapon.category
          };
          this.original = {...this.weaponType};
        });
    });
  }

  onSubmit(): void {
    this.weaponTypeService.putWeaponType(this.uuid!, this.weaponType!)
      .subscribe(() => this.router.navigate(['/weapontypes']));
  }
}

