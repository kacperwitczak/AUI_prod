import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { WeaponTypes } from "../model/weaponTypes";
import { WeaponTypeForm } from '../model/weaponType-form';
import { WeaponTypeDetails } from '../model/weaponType-details';

@Injectable()
export class WeaponTypeService {
  constructor(private http: HttpClient) { }

  getWeaponTypes(): Observable<any> {
    return this.http.get<WeaponTypes>('/api/weapontypes');
  }

  getWeaponType(uuid: string): Observable<WeaponTypeDetails> {
    return this.http.get<WeaponTypeDetails>('/api/weapontypes/' + uuid);
  }

  deleteWeaponType(id: string): Observable<void> {
    return this.http.delete<void>(`/api/weapontypes/${id}`);
  }

  putWeaponType(uuid: string, request: WeaponTypeForm): Observable<any> {
    return this.http.put('/api/weapontypes/' + uuid, request);
  }

  postWeaponType(request: WeaponTypeForm): Observable<any> {
    return this.http.post('/api/weapontypes', request);
  }
}
