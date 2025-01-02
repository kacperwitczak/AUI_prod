package com.example.aui.Weapon.Service.Impl;


import com.example.aui.Weapon.Entity.Weapon;
import com.example.aui.Weapon.Repository.api.WeaponRepository;
import com.example.aui.Weapon.Service.Api.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.example.aui.config.AppConfig.weaponTypeUrl;


@Service
public class WeaponDefaultService implements WeaponService {
    private WeaponRepository repository;
    private RestTemplate restTemplate;

    @Autowired
    public WeaponDefaultService(WeaponRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public Optional<Weapon> find(UUID id) {
        Optional<Weapon> w = repository.findById(id);

        return w;
    }

    public List<Weapon> findAll() {
        List<Weapon> weapons = repository.findAll();

        return weapons;
    }

    public Weapon create(Weapon w) {
        w.setId(UUID.randomUUID());
        return repository.save(w);
    }

    public Weapon update(Weapon w) {
        return repository.save(w);
    }

    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    public void deleteByCategory(UUID id) {
        repository.deleteAllByCategoryId(id);
    }

    public void secretCreate(Weapon w) {
        repository.save(w);
    }

    public List<Weapon> findAllByCategory(UUID id) {
        List<Weapon> w = repository.findAllByCategoryId(id);

        return w;
    }
}
