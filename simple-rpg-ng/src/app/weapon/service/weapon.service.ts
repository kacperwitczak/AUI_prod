import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Weapons } from "../model/weapons";
import { WeaponDetails } from "../model/weapon-details";
import { WeaponForm } from "../model/weapon-form";

@Injectable()
export class WeaponService {
  constructor(private http: HttpClient) {

  }
  getWeapons(): Observable<Weapons> {
    let res = this.http.get<Weapons>('http://localhost:8080/api/weapons');
    console.log(res.forEach(element => { console.log(element); }));
    return this.http.get<Weapons>('/api/weapons');
  }

  getWeapon(uuid: string): Observable<WeaponDetails> {
    return this.http.get<WeaponDetails>('/api/weapons/' + uuid);
  }

  deleteWeapon(uuid: string): Observable<any> {
    return this.http.delete('/api/weapons/' + uuid);
  }

  putWeapon(uuid: string, request: WeaponForm): Observable<any> {
    return this.http.put('/api/weapons/' + uuid, request);
  }

  postWeapon(request: WeaponForm): Observable<any> {
    return this.http.post('/api/weapons', request);
  }
}
