package com.example.aui.WeaponType.DTOs;

import com.example.aui.Weapon.Entity.Weapon;
import com.example.aui.WeaponType.Entity.WeaponType;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class WeaponTypeRequest {
    private String category;
    private String description;

    public static WeaponType toWeaponType(WeaponTypeRequest w) {
        return WeaponType.builder()
                .category(w.getCategory())
                .description(w.getDescription())
                .build();
    }
}
