package Weapon.Entity;

import Weapon.DTOs.WeaponResponse;
import WeaponType.Entity.WeaponType;
import lombok.*;

import java.io.Serializable;
import java.util.Comparator;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class Weapon implements Serializable, Comparable<Weapon> {
    private UUID id;
    private String name;
    private String description;
    private Integer damage;
    private Integer range;
    private WeaponType weaponType;

    @Override
    public int compareTo(Weapon o) {
        return name.compareTo(o.name);
    }

    public static WeaponResponse toWeaponResponse(Weapon w) {
        return WeaponResponse.builder()
                .name(w.getName())
                .description(w.getDescription())
                .damage(w.getDamage())
                .range(w.getRange())
                .weaponTypeCategory(w.getWeaponType().getCategory())
                .build();
    }
}
