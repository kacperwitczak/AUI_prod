import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { WeaponTypes } from "../model/weaponTypes";

@Injectable()
export class WeaponTypeService {
  constructor(private http: HttpClient) { }

  getWeaponTypes(): Observable<any> {
    return this.http.get<WeaponTypes>('/api/weapontypes');
  }

  deleteWeaponType(id: string): Observable<void> {
    return this.http.delete<void>(`/api/weapontypes/${id}`);
  }
}
