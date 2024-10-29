import { Component, OnInit } from '@angular/core';
import { WeaponService } from "../../service/weapon.service";
import { ActivatedRoute, Router } from "@angular/router";
import { WeaponDetails } from "../../model/weapon-details";

@Component({
  selector: 'app-weapon-view',
  templateUrl: './weapon-view.component.html',
  styleUrls: ['./weapon-view.component.css']
})
export class WeaponViewComponent implements OnInit {
  weapon: WeaponDetails | undefined;
  
  constructor(private service: WeaponService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getWeapon(params['uuid'])
        .subscribe(weapon => this.weapon = weapon);
    });
  }
}
