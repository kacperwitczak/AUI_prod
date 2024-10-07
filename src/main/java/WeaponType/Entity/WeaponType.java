package WeaponType.Entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import Weapon.Entity.Weapon;
import WeaponType.DTOs.WeaponTypeResponse;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class WeaponType implements Serializable, Comparable<WeaponType> {
    private UUID id;
    private String category;
    private String description;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Weapon> weapons;

    @Override
    public int compareTo(WeaponType o) {
        return this.category.compareTo(o.category);
    }

    public static WeaponTypeResponse toWeaponTypeResponse(WeaponType w) {
        return WeaponTypeResponse.builder()
                .category(w.getCategory())
                .description(w.getDescription())
                .weapons(w.getWeapons().stream().map(Weapon::toWeaponResponse).collect(Collectors.toList()))
                .build();
    }
}
