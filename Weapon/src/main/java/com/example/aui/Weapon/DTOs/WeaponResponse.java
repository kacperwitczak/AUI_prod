package com.example.aui.Weapon.DTOs;

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
    private Integer damage;
    private Integer range;
    private UUID weaponTypeId;
    private UUID id;
}
