package com.example.aui.WeaponType.Entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.aui.WeaponType.DTOs.WeaponTypeResponse;
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

    @Override
    public int compareTo(WeaponType o) {
        return this.category.compareTo(o.category);
    }

    public static WeaponTypeResponse toWeaponTypeResponse(WeaponType w) {
        return WeaponTypeResponse.builder()
                .category(w.getCategory())
                .description(w.getDescription())
                .id(w.getId())
                .build();
    }
}
