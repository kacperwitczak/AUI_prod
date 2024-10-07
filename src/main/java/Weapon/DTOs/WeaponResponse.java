package Weapon.DTOs;

import WeaponType.DTOs.WeaponTypeResponse;
import WeaponType.Entity.WeaponType;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class WeaponResponse {
    private String name;
    private String description;
    private Integer damage;
    private Integer range;
    private String weaponTypeCategory;
}
