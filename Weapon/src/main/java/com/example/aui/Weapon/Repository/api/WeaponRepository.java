package com.example.aui.Weapon.Repository.api;

import com.example.aui.Weapon.Entity.Weapon;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, UUID> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Weapon w WHERE w.weaponTypeId = :id")
    void deleteAllByCategoryId(UUID id);

    @Modifying
    @Transactional
    @Query("SELECT w FROM Weapon w WHERE w.weaponTypeId = :id")
    List<Weapon> findAllByCategoryId(UUID id);
}
