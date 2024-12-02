import { Component, OnInit } from '@angular/core';
import { range } from 'rxjs';
import { WeaponForm } from '../../model/weapon-form';
import { WeaponService } from '../../service/weapon.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-weapon-add',
  templateUrl: './weapon-add.component.html',
  styleUrls: ['./weapon-add.component.css']
})
export class WeaponAddComponent implements OnInit {
  weapon: WeaponForm = {
    name: '', description: '', range: 0, damage: 0,
    weaponTypeId: ''
  };
  
  constructor(
    private weaponService: WeaponService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.weapon.weaponTypeId = params['wt_id'];
    });
  }

  onSubmit(): void {
    console.log(this.weapon);
    this.weaponService.postWeapon(this.weapon)
      .subscribe(() => {
        this.router.navigate(['/weapontypes', this.weapon.weaponTypeId]);
      });
  }
}
