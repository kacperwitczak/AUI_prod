package com.example.aui.Initialize;

import com.example.aui.Weapon.Entity.Weapon;
import com.example.aui.Weapon.Service.Api.WeaponService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer implements InitializingBean {

    private final WeaponService weaponService;

    @Autowired
    public DataInitializer(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Weapon sword = Weapon.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a7"))
                .name("Sword")
                .description("sharp")
                .damage(50)
                .range(1)
                .weaponTypeId(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                .build();

        Weapon axe = Weapon.builder()
                .id(UUID.fromString("14804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                .name("Axe")
                .description("wood chopper")
                .damage(60)
                .range(1)
                .weaponTypeId(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                .build();

        Weapon bow = Weapon.builder()
                .id(UUID.fromString("34804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                .name("Bow")
                .description("arrows")
                .damage(40)
                .range(50)
                .weaponTypeId(UUID.fromString("24804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                .build();

        Weapon crossbow = Weapon.builder()
                .id(UUID.fromString("44804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                .name("Crossbow")
                .description("desc")
                .damage(55)
                .range(60)
                .weaponTypeId(UUID.fromString("24804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                .build();

        weaponService.secretCreate(sword);
        weaponService.secretCreate(axe);
        weaponService.secretCreate(bow);
        weaponService.secretCreate(crossbow);
    }
}