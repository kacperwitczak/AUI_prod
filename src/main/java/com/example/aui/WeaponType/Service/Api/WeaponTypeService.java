package com.example.aui.WeaponType.Service.Api;

import com.example.aui.WeaponType.Entity.WeaponType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WeaponTypeService {
    Optional<WeaponType> find(UUID id);
    List<WeaponType> findAll();
    void create(WeaponType w);
    void update(WeaponType w);
    void delete(UUID id);
}
