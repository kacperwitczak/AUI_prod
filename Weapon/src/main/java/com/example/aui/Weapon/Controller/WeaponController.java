package com.example.aui.Weapon.Controller;

import com.example.aui.Weapon.DTOs.WeaponRequest;
import com.example.aui.Weapon.DTOs.WeaponResponse;
import com.example.aui.Weapon.DTOs.WeaponsResponse;
import com.example.aui.Weapon.Entity.Weapon;
import com.example.aui.Weapon.Service.Api.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

import static com.example.aui.config.AppConfig.weaponTypeUrl;

@RestController
@RequestMapping("/api/weapons")
public class WeaponController {
    private final WeaponService weaponService;
    private final RestTemplate restTemplate;


    @Autowired
    public WeaponController(WeaponService weaponService, RestTemplate restTemplate) {
        this.weaponService = weaponService;
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public ResponseEntity<WeaponResponse> createWeapon(@RequestBody WeaponRequest weaponRequest) {
        String weaponTypeServiceUrl = UriComponentsBuilder
                .fromUriString(weaponTypeUrl + "api/weapontypes/exists/{id}")
                .buildAndExpand(weaponRequest.getWeaponTypeId())
                .toUriString();

        ResponseEntity<Boolean> exists = restTemplate.getForEntity(weaponTypeServiceUrl, Boolean.class);

        if (!exists.getStatusCode().is2xxSuccessful()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!exists.getBody().booleanValue()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Weapon w = WeaponRequest.toWeapon(weaponRequest);
        w = weaponService.create(w);

        return new ResponseEntity<>(Weapon.toWeaponResponse(w), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WeaponResponse> putWeapon(@PathVariable UUID id, @RequestBody WeaponRequest weaponRequest) {
        var exists = weaponService.find(id).isPresent();

        if (!exists) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Weapon w = WeaponRequest.toWeapon(weaponRequest);
        w.setId(id);
        w = weaponService.update(w);

        return new ResponseEntity<>(Weapon.toWeaponResponse(w), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeapon(@PathVariable UUID id) {
        var exists = weaponService.find(id).isPresent();

        if (!exists) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        weaponService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/weapontypes/{id}")
    public ResponseEntity<Void> deleteWeaponByCategory(@PathVariable UUID id) {
        weaponService.deleteByCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeaponResponse> getWeapon(@PathVariable UUID id) {
        var w = weaponService.find(id);

        if (w.isPresent()) {
            return new ResponseEntity<>(Weapon.toWeaponResponse(w.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/weapontypes/{id}")
    public ResponseEntity<List<Weapon>> getWeaponByCategory(@PathVariable UUID id) {
        var w = weaponService.findAllByCategory(id);

        return new ResponseEntity<>(w, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<WeaponsResponse> getWeapons() {
        var weapons = weaponService.findAll();

        return new ResponseEntity<>(WeaponsResponse.ToWeaponsResponse(weapons), HttpStatus.OK);
    }

}
