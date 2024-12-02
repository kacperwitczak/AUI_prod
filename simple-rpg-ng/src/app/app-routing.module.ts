import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WeaponListComponent } from "./weapon/view/weapon-list/weapon-list.component";
import { WeaponViewComponent } from "./weapon/view/weapon-view/weapon-view.component";
import { WeaponEditComponent } from "./weapon/view/weapon-edit/weapon-edit.component";
import { WeaponTypeListComponent } from './weaponType/view/weapon-type-list/weapon-type-list.component';
import { WeaponTypeDetailsComponent } from './weaponType/view/weapon-type-details/weapon-type-details.component';
import { WeaponTypeEditComponent } from './weaponType/view/weapon-type-edit/weapon-type-edit.component';
import { WeaponTypeAddComponent } from './weaponType/view/weapon-type-add/weapon-type-add.component';
import { WeaponAddComponent } from './weapon/view/weapon-add/weapon-add.component';

const routes: Routes = [
  {
    component: WeaponListComponent,
    path: "weapons"
  },
  {
    component: WeaponViewComponent,
    path: "weapons/:uuid"
  },
  {
    component: WeaponEditComponent,
    path: "weapons/:uuid/edit"
  },
  {
    component: WeaponTypeListComponent,
    path: "weapontypes"
  },
  {
    component: WeaponTypeDetailsComponent,
    path: "weapontypes/:id"
  },
  {
    component: WeaponTypeEditComponent,
    path: "weapontypes/:id/edit"
  },
  {
    component: WeaponViewComponent,
    path: "weapontypes/:wt_id/weapons/:uuid"
  },
  {
    component: WeaponEditComponent,
    path: "weapontypes/:wt_id/weapons/:uuid/edit"
  },
  {
    component: WeaponTypeAddComponent,
    path: "add/weapontypes"
  },
  {
    component: WeaponAddComponent,
    path: "weapontypes/:wt_id/add"
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
