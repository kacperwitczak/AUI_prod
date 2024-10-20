package com.example.aui.WeaponType.DTOs;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class WeaponTypeResponse {
    private UUID id;
    private String category;
    private String description;
}
