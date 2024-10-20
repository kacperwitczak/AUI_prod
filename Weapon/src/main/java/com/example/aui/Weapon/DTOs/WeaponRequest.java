package com.example.aui.Weapon.DTOs;

import com.example.aui.Weapon.Entity.Weapon;
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
                .weaponTypeId(w.getWeaponTypeId())
                .build();
    }
}
