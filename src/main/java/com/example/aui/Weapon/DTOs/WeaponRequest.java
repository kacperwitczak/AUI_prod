package com.example.aui.Weapon.DTOs;

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
public class WeaponRequest {
    private String name;
    private String description;
    private Integer damage;
    private Integer range;
    private UUID weaponTypeId;

    public static Weapon toWeapon(WeaponRequest w) {
        return Weapon.builder()
                .name(w.getName())
                .description(w.getDescription())
                .damage(w.getDamage())
                .range(w.getRange())
                .weaponType(WeaponType.builder()
                        .id(w.getWeaponTypeId())
                        .build()
                )
                .build();
    }
}
