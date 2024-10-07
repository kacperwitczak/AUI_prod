package com.example.aui.Weapon.DTOs;

import lombok.*;

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
