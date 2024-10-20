package com.example.aui.WeaponType.Service.Impl;

import com.example.aui.WeaponType.Entity.WeaponType;
import com.example.aui.WeaponType.Repository.api.WeaponTypeRepository;
import com.example.aui.WeaponType.Service.Api.WeaponTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.example.aui.config.AppConfig.weaponUrl;


@Service
public class WeaponTypeDefaultService implements WeaponTypeService {
    private WeaponTypeRepository repository;
    private RestTemplate restTemplate;

    @Autowired
    public WeaponTypeDefaultService(WeaponTypeRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public Optional<WeaponType> find(UUID id) {
        Optional<WeaponType> w = repository.findById(id);

        return w;
    }

    public List<WeaponType> findAll() {
        List<WeaponType> w = repository.findAll();

        return w;
    }

    public WeaponType create(WeaponType w) {
        w.setId(UUID.randomUUID());
        return repository.save(w);
    }

    public WeaponType update(WeaponType w) {
        return repository.save(w);
    }

    public void delete(UUID id) {
        Optional<WeaponType> w = repository.findById(id);

        if (w.isPresent()) {
            String weaponTypeServiceUrl = UriComponentsBuilder
                    .fromUriString(weaponUrl + "api/weapons/weapontypes/{id}")
                    .buildAndExpand(w.get().getId())
                    .toUriString();

            restTemplate.delete(weaponTypeServiceUrl);

            repository.delete(w.get());
        }
    }

    public void secretCreate(WeaponType w) {
        repository.save(w);
    }
}
