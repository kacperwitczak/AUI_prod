package com.example.aui.Weapon.DTOs;

import com.example.aui.Weapon.Entity.Weapon;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class WeaponsResponse {
    List<WeaponResponse> weapons;

    public static WeaponsResponse ToWeaponsResponse(List<Weapon> weapons) {
        WeaponsResponse weaponsResponse = new WeaponsResponse();
        weaponsResponse.weapons = weapons.stream().map(Weapon::toWeaponResponse).collect(Collectors.toList());
        return weaponsResponse;
    }
}
