package com.example.aui.WeaponType.Controller;

import com.example.aui.Weapon.DTOs.WeaponRequest;
import com.example.aui.Weapon.DTOs.WeaponResponse;
import com.example.aui.Weapon.DTOs.WeaponsResponse;
import com.example.aui.Weapon.Entity.Weapon;
import com.example.aui.Weapon.Service.Api.WeaponService;
import com.example.aui.WeaponType.DTOs.WeaponTypeRequest;
import com.example.aui.WeaponType.DTOs.WeaponTypeResponse;
import com.example.aui.WeaponType.DTOs.WeaponTypesResponse;
import com.example.aui.WeaponType.Entity.WeaponType;
import com.example.aui.WeaponType.Service.Api.WeaponTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/weapontypes")
public class WeaponTypeController {
    private final WeaponTypeService weaponTypeService;

    @Autowired
    public WeaponTypeController(WeaponTypeService weaponTypeService) {
        this.weaponTypeService = weaponTypeService;
    }

    @PostMapping
    public ResponseEntity<WeaponTypeResponse> createWeaponType(@RequestBody WeaponTypeRequest weaponTypeRequest) {
        WeaponType w = WeaponTypeRequest.toWeaponType(weaponTypeRequest);
        w = weaponTypeService.create(w);

        return new ResponseEntity<>(WeaponType.toWeaponTypeResponse(w), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WeaponTypeResponse> putWeaponType(@PathVariable UUID id, @RequestBody WeaponTypeRequest weaponTypeRequest) {
        var exists = weaponTypeService.find(id).isPresent();

        if (!exists) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        WeaponType w = WeaponTypeRequest.toWeaponType(weaponTypeRequest);
        w.setId(id);
        w = weaponTypeService.update(w);

        return new ResponseEntity<>(WeaponType.toWeaponTypeResponse(w), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeaponType(@PathVariable UUID id) {
        var exists = weaponTypeService.find(id).isPresent();

        if (!exists) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        weaponTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeaponTypeResponse> getWeaponType(@PathVariable UUID id) {
        var w = weaponTypeService.find(id);

        if (w.isPresent()) {
            return new ResponseEntity<>(WeaponType.toWeaponTypeResponse(w.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<WeaponTypesResponse> getWeaponTypes() {
        var weaponTypes = weaponTypeService.findAll();

        return new ResponseEntity<>(WeaponTypesResponse.ToWeaponsResponse(weaponTypes), HttpStatus.OK);
    }

}
