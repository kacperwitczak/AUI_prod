package com.example.aui.WeaponType.Service.Impl;

import com.example.aui.WeaponType.Entity.WeaponType;
import com.example.aui.WeaponType.Repository.api.WeaponTypeRepository;
import com.example.aui.WeaponType.Service.Api.WeaponTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WeaponTypeDefaultService implements WeaponTypeService {
    private WeaponTypeRepository repository;

    @Autowired
    public WeaponTypeDefaultService(WeaponTypeRepository repository) {
        this.repository = repository;
    }

    public Optional<WeaponType> find(UUID id) {
        return repository.findById(id);
    }

    public List<WeaponType> findAll() {
        return repository.findAll();
    }

    public void create(WeaponType w) {
        repository.save(w);
    }

    public void update(WeaponType w) {
        repository.save(w);
    }

    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
