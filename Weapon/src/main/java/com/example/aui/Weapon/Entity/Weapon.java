package com.example.aui.Weapon.Entity;

import com.example.aui.Weapon.DTOs.WeaponResponse;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "weapons")
public class Weapon implements Serializable, Comparable<Weapon> {
    @Id
    private UUID id;
    private String name;
    private String description;
    private Integer damage;
    private Integer range;
    private UUID weaponTypeId;
    @Override
    public int compareTo(Weapon o) {
        return name.compareTo(o.name);
    }

    public static WeaponResponse toWeaponResponse(Weapon w) {
        return WeaponResponse.builder()
                .name(w.getName())
                .damage(w.getDamage())
                .range(w.getRange())
                .weaponTypeId(w.getWeaponTypeId())
                .id(w.getId())
                .build();
    }
}
