package com.example.aui.Weapon.Service.Impl;

import com.example.aui.Weapon.Entity.Weapon;
import com.example.aui.Weapon.Repository.api.WeaponRepository;
import com.example.aui.Weapon.Service.Api.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WeaponDefaultService implements WeaponService {
    private WeaponRepository repository;

    @Autowired
    public WeaponDefaultService(WeaponRepository repository) {
        this.repository = repository;
    }

    public Optional<Weapon> find(UUID id) {
        return repository.findById(id);
    }

    public List<Weapon> findAll() {
        return repository.findAll();
    }

    public void create(Weapon w) {
        repository.save(w);
    }

    public void update(Weapon w) {
        repository.save(w);
    }

    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
