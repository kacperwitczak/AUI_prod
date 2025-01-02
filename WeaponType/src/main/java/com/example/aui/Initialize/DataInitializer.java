package com.example.aui.Initialize;
import com.example.aui.WeaponType.Entity.WeaponType;
import com.example.aui.WeaponType.Service.Api.WeaponTypeService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer implements InitializingBean {

    private final WeaponTypeService weaponTypeService;

    @Autowired
    public DataInitializer(WeaponTypeService weaponTypeService) {
        this.weaponTypeService = weaponTypeService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        WeaponType melee = WeaponType.builder()
                .id(UUID.fromString("c4804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                .category("Melee")
                .description("Close-range weapons")
                .build();

        WeaponType ranged = WeaponType.builder()
                .id(UUID.fromString("24804e0f-769e-4ab9-9ebe-0578fb4f00a6"))
                .category("Ranged")
                .description("Long-range weapons")
                .build();

        weaponTypeService.secretCreate(melee);
        weaponTypeService.secretCreate(ranged);
    }
}