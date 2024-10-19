package com.example.aui.Initialize;


import com.example.aui.Weapon.Entity.Weapon;
import com.example.aui.Weapon.Service.Api.WeaponService;
import com.example.aui.WeaponType.Entity.WeaponType;
import com.example.aui.WeaponType.Service.Api.WeaponTypeService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer implements InitializingBean {

    private final WeaponService weaponService;
    private final WeaponTypeService weaponTypeService;

    @Autowired
    public DataInitializer(WeaponService weaponService, WeaponTypeService weaponTypeService) {
        this.weaponService = weaponService;
        this.weaponTypeService = weaponTypeService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        WeaponType melee = WeaponType.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                .category("Melee")
                .description("Close-range weapons")
                .build();

        Weapon sword = Weapon.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a7"))
                .name("Sword")
                .description("sharp")
                .damage(50)
                .range(1)
                .weaponType(melee)
                .build();

        Weapon axe = Weapon.builder()
                .id(UUID.randomUUID())
                .name("Axe")
                .description("wood chopper")
                .damage(60)
                .range(1)
                .weaponType(melee)
                .build();

        WeaponType ranged = WeaponType.builder()
                .id(UUID.randomUUID())
                .category("Ranged")
                .description("Long-range weapons")
                .build();

        Weapon bow = Weapon.builder()
                .id(UUID.randomUUID())
                .name("Bow")
                .description("arrows")
                .damage(40)
                .range(50)
                .weaponType(ranged)
                .build();

        Weapon crossbow = Weapon.builder()
                .id(UUID.randomUUID())
                .name("Crossbow")
                .description("desc")
                .damage(55)
                .range(60)
                .weaponType(ranged)
                .build();

        weaponTypeService.secretCreate(melee);
        weaponTypeService.secretCreate(ranged);
        weaponService.secretCreate(sword);
        weaponService.secretCreate(axe);
        weaponService.secretCreate(bow);
        weaponService.secretCreate(crossbow);
    }
}