package com.example.aui.Weapon.Entity;

import com.example.aui.Weapon.DTOs.WeaponResponse;
import com.example.aui.WeaponType.Entity.WeaponType;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "weaponType")
    @JsonBackReference
    private WeaponType weaponType;

    @Override
    public int compareTo(Weapon o) {
        return name.compareTo(o.name);
    }

    public static WeaponResponse toWeaponResponse(Weapon w) {
        return WeaponResponse.builder()
                .name(w.getName())
                .damage(w.getDamage())
                .range(w.getRange())
                .weaponTypeCategory(w.getWeaponType().getCategory())
                .id(w.getId())
                .build();
    }
}
