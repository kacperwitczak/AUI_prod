import { Component, OnInit } from '@angular/core';
import { WeaponService } from '../../service/weapon.service';
import { ActivatedRoute, Router } from '@angular/router';
import { WeaponForm } from '../../model/weapon-form';
import { WeaponTypeService } from "../../../weaponType/service/weaponType.service";
import { WeaponTypes } from "../../../weaponType/model/weaponTypes";

@Component({
  selector: 'app-weapon-edit',
  templateUrl: './weapon-edit.component.html',
  styleUrls: ['./weapon-edit.component.css']
})
export class WeaponEditComponent implements OnInit {
  uuid: string | undefined;
  weapon: WeaponForm | undefined;
  original: WeaponForm | undefined;
  weaponTypes: WeaponTypes | undefined;

  constructor(
    private weaponService: WeaponService,
    private weaponTypeService: WeaponTypeService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.weaponTypeService.getWeaponTypes()
        .subscribe(weaponTypes => this.weaponTypes = weaponTypes);

      this.weaponService.getWeapon(params['uuid'])
        .subscribe(weapon => {
          this.uuid = weapon.id;
          this.weapon = {
            name: weapon.name,
            description: weapon.description,
            damage: weapon.damage,
            range: weapon.range,
            weaponTypeId: weapon.weaponTypeId
          };
          this.original = {...this.weapon};
        });
    });
  }

  onSubmit(): void {
    this.weaponService.putWeapon(this.uuid!, this.weapon!)
      .subscribe(() => this.router.navigate(['/weapons']));
  }
}
