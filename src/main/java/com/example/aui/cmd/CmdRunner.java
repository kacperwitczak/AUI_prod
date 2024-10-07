package com.example.aui.cmd;

import com.example.aui.Weapon.Entity.Weapon;
import com.example.aui.Weapon.Service.Api.WeaponService;
import com.example.aui.WeaponType.Service.Api.WeaponTypeService;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

@Component
public class CmdRunner implements CommandLineRunner {

    private ObjectWriter writer;
    private WeaponService weaponService;
    private WeaponTypeService weaponTypeService;

    @Autowired
    public CmdRunner(ObjectWriter writer, WeaponService weaponService, WeaponTypeService weaponTypeService) {
        this.writer = writer;
        this.weaponService = weaponService;
        this.weaponTypeService = weaponTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while (true) {
            command = scanner.next();
            switch (command) {
                case "get_weapontypes" -> {
                    System.out.println(writer.writeValueAsString(weaponTypeService.findAll()));
                }
                case "get_weapons" -> {
                    System.out.println(writer.writeValueAsString(weaponService.findAll()));
                }
                case "delete_weapon" -> {
                    try {
                        UUID uuid = UUID.fromString(scanner.next());
                        weaponService.delete(uuid);
                    } catch (NoSuchElementException ex) {
                        System.out.println("Not Found");
                    }
                }
                case "put_weapon" -> {
                    UUID uuid = UUID.fromString(scanner.next());
                    weaponTypeService.find(uuid).ifPresent( x -> {
                        Weapon w = Weapon.builder()
                                .id(UUID.randomUUID())
                                .damage(100)
                                .description("xd")
                                .name("xddd")
                                .range(123)
                                .weaponType(x)
                                .build();

                        weaponService.create(w);
                    });
                }
                case "quit" -> {
                    break main_loop;
                }
            }
        }
    }
}
