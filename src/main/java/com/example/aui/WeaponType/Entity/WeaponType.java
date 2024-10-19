package com.example.aui.WeaponType.Entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.aui.Weapon.Entity.Weapon;
import com.example.aui.WeaponType.DTOs.WeaponTypeResponse;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "weapon_types")
public class WeaponType implements Serializable, Comparable<WeaponType> {
    @Id
    private UUID id;
    private String category;
    private String description;

    @OneToMany(mappedBy = "weaponType", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonManagedReference
    private List<Weapon> weapons;

    @Override
    public int compareTo(WeaponType o) {
        return this.category.compareTo(o.category);
    }

    public static WeaponTypeResponse toWeaponTypeResponse(WeaponType w) {
        return WeaponTypeResponse.builder()
                .category(w.getCategory())
                .description(w.getDescription())
                .id(w.getId())
                .weapons(w.getWeapons() != null
                        ? w.getWeapons().stream().map(Weapon::toWeaponResponse).collect(Collectors.toList())
                        : Collections.emptyList())
                .build();
    }
}
