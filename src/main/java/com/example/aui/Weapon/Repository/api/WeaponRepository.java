package com.example.aui.Weapon.Repository.api;

import com.example.aui.Weapon.Entity.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, UUID> {
}
