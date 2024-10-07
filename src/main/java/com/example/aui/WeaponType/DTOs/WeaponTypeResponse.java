package com.example.aui.WeaponType.DTOs;

import com.example.aui.Weapon.DTOs.WeaponResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class WeaponTypeResponse {
    private String category;
    private String description;
    private List<WeaponResponse> weapons;
}
