package com.example.aui.Weapon.Service.Api;

import com.example.aui.Weapon.Entity.Weapon;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WeaponService {
    Optional<Weapon> find(UUID id);
    List<Weapon> findAll();
    void create(Weapon w);
    void update(Weapon w);
    void delete(UUID id);
}
