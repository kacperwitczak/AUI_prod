import { Component, OnInit } from '@angular/core';
import { WeaponService } from "../../service/weapon.service";
import { Weapons } from "../../model/weapons";
import { Weapon } from "../../model/weapon";

@Component({
  selector: 'app-weapon-list',
  templateUrl: './weapon-list.component.html',
  styleUrls: ['./weapon-list.component.css']
})
export class WeaponListComponent implements OnInit {
  constructor(private service: WeaponService) {
  }

  weapons: Weapons | undefined;

  ngOnInit(): void {
    this.service.getWeapons().subscribe(weapons => this.weapons = weapons);
  }

  onDelete(weapon: Weapon): void {
    this.service.deleteWeapon(weapon.id).subscribe(() => this.ngOnInit());
  }

}
