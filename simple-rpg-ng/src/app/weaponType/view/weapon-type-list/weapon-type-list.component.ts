import { Component, OnInit } from '@angular/core';
import { WeaponTypes } from '../../model/weaponTypes';
import { WeaponTypeService } from '../../service/weaponType.service';

@Component({
  selector: 'app-weapon-type-list',
  templateUrl: './weapon-type-list.component.html',
  styleUrls: ['./weapon-type-list.component.css']
})
export class WeaponTypeListComponent implements OnInit {
    constructor(private service: WeaponTypeService) {

    }

    weaponTypes: WeaponTypes | undefined;

    ngOnInit(): void {
        this.service.getWeaponTypes().subscribe(weaponTypes => this.weaponTypes = weaponTypes);
    }

    onDelete(id: string): void {
        this.service.deleteWeaponType(id).subscribe(() => this.ngOnInit());
    }
}
