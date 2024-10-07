package com.example.aui.WeaponType.Repository.api;

import com.example.aui.Weapon.Entity.Weapon;
import com.example.aui.WeaponType.Entity.WeaponType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WeaponTypeRepository extends JpaRepository<WeaponType, UUID> {
}
