import { Component, OnInit } from '@angular/core';
import { WeaponTypeDetails } from '../../model/weaponType-details';
import { WeaponTypeService } from '../../service/weaponType.service';
import { ActivatedRoute, Router } from '@angular/router';
import { WeaponService } from 'src/app/weapon/service/weapon.service';

@Component({
  selector: 'app-weapon-type-details',
  templateUrl: './weapon-type-details.component.html',
  styleUrls: ['./weapon-type-details.component.css']
})
export class WeaponTypeDetailsComponent implements OnInit {
  weaponType: WeaponTypeDetails | undefined;
  
  constructor(private service: WeaponTypeService, private weaponService: WeaponService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      const weaponTypeId = params['id'];
      this.service.getWeaponType(weaponTypeId).subscribe({
        next: (weaponType) => {
          this.weaponType = weaponType;
          if (this.weaponType) {
            this.weaponService.getWeaponsByType(this.weaponType.id).subscribe({
              next: (weapons) => {
                this.weaponType!.weapons = weapons;
              },
              error: (err) => console.error('Error fetching weapons:', err)
            });
          }
        },
        error: (err) => console.error('Error fetching weapon type:', err)
      });
    });
  }

  onDeleteWeapon(id: string): void {
    this.weaponService.deleteWeapon(id)
      .subscribe(() => this.ngOnInit());
  }
}