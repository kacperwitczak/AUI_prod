import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WeaponListComponent } from "./weapon/view/weapon-list/weapon-list.component";
import { WeaponViewComponent } from "./weapon/view/weapon-view/weapon-view.component";
import { WeaponEditComponent } from "./weapon/view/weapon-edit/weapon-edit.component";
import { WeaponTypeListComponent } from './weaponType/view/weapon-type-list/weapon-type-list.component';

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
    path: "weaponTypes"
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
