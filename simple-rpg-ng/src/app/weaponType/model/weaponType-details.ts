import { Weapons } from "src/app/weapon/model/weapons";

export interface WeaponTypeDetails {
    id: string;
    category: string;
    description: string;
    weapons: Weapons;
  }
  