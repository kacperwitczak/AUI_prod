import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { HttpClientModule } from "@angular/common/http";
import { WeaponListComponent } from './weapon/view/weapon-list/weapon-list.component';
import { WeaponService } from './weapon/service/weapon.service';
import { WeaponViewComponent } from './weapon/view/weapon-view/weapon-view.component';
import { WeaponEditComponent } from './weapon/view/weapon-edit/weapon-edit.component';
import { FormsModule } from "@angular/forms";
import { WeaponTypeListComponent } from './weaponType/view/weapon-type-list/weapon-type-list.component';
import { WeaponTypeEditComponent } from './weaponType/view/weapon-type-edit/weapon-type-edit.component';
import { WeaponTypeDetailsComponent } from './weaponType/view/weapon-type-details/weapon-type-details.component';
import { WeaponTypeService } from './weaponType/service/weaponType.service';

/**
 * Application main module.
 */
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    WeaponListComponent,
    WeaponViewComponent,
    WeaponEditComponent,
    WeaponTypeListComponent,
    WeaponTypeEditComponent,
    WeaponTypeDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    WeaponService,
    WeaponTypeService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}
