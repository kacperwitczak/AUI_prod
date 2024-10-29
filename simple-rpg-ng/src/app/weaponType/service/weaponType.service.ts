import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { WeaponTypes } from "../model/weaponTypes";

@Injectable({
  providedIn: 'root'
})
export class WeaponTypeService {

  constructor(private http: HttpClient) {

  }

  getWeaponTypes(): Observable<WeaponTypes> {
    return this.http.get<WeaponTypes>('/api/weaponTypes');
  }

}
