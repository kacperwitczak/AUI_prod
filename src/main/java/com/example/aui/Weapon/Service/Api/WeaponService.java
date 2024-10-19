package com.example.aui.Weapon.Service.Api;

import com.example.aui.Weapon.Entity.Weapon;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WeaponService {
    Optional<Weapon> find(UUID id);
    List<Weapon> findAll();
    Weapon create(Weapon w);
    Weapon update(Weapon w);
    void delete(UUID id);
    void secretCreate(Weapon w);
}
