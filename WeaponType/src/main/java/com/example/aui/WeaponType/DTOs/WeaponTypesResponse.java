package com.example.aui.WeaponType.DTOs;

import com.example.aui.WeaponType.Entity.WeaponType;
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
public class WeaponTypesResponse {
    List<WeaponTypeResponse> weaponTypes;

    public static WeaponTypesResponse ToWeaponsResponse(List<WeaponType> weaponTypes) {
        WeaponTypesResponse weaponTypesResponse = new WeaponTypesResponse();
        weaponTypesResponse.weaponTypes = weaponTypes.stream().map(WeaponType::toWeaponTypeResponse).collect(Collectors.toList());
        return weaponTypesResponse;
    }
}
