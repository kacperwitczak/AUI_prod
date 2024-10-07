import Weapon.DTOs.WeaponResponse;
import Weapon.Entity.Weapon;
import WeaponType.Entity.WeaponType;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        WeaponType melee = WeaponType.builder()
                .id(UUID.randomUUID())
                .category("Melee")
                .description("Close-range weapons")
                .build();

        Weapon sword = Weapon.builder()
                .id(UUID.randomUUID())
                .name("Sword")
                .description("sharp")
                .damage(50)
                .range(1)
                .weaponType(melee)
                .build();

        Weapon axe = Weapon.builder()
                .id(UUID.randomUUID())
                .name("Axe")
                .description("wood chopper")
                .damage(60)
                .range(1)
                .weaponType(melee)
                .build();

        melee.setWeapons(List.of(sword, axe));

        WeaponType ranged = WeaponType.builder()
                .id(UUID.randomUUID())
                .category("Ranged")
                .description("Long-range weapons")
                .build();

        Weapon bow = Weapon.builder()
                .id(UUID.randomUUID())
                .name("Bow")
                .description("arrows")
                .damage(40)
                .range(50)
                .weaponType(ranged)
                .build();

        Weapon crossbow = Weapon.builder()
                .id(UUID.randomUUID())
                .name("Crossbow")
                .description("desc")
                .damage(55)
                .range(60)
                .weaponType(ranged)
                .build();

        ranged.setWeapons(List.of(bow, crossbow));

        List<WeaponType> weaponTypes = List.of(melee, ranged);

        System.out.println("zadanie 2");
        weaponTypes.forEach(x -> {
            System.out.println(x);
            x.getWeapons().forEach(y -> System.out.println('\t' + y.toString()));
        });

        System.out.println("zadanie 3");
        Set<Weapon> weapons = weaponTypes.stream()
                .flatMap(x -> x.getWeapons().stream())
                .collect(Collectors.toSet());

        weapons.forEach(System.out::println);

        System.out.println("ZADANIE 4");
        weapons.stream()
                .filter(car -> !car.getWeaponType().getCategory().equals("Melee"))
                .sorted(Weapon::compareTo)
                .forEach(System.out::println);

        System.out.println("ZADANIE 5");
        List<WeaponResponse> carsDto = weapons.stream().map(Weapon::toWeaponResponse).toList();
        carsDto.forEach(System.out::println);

        System.out.println("ZADANIE 6");
        String filepath = "data.dat";
        ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream(filepath));
        output.writeObject(weaponTypes);
        output.close();
        System.out.println("Zapisano do " + filepath);

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(filepath));
        var weaponTypesFromFile = (List<WeaponType>)input.readObject();
        input.close();
        System.out.println("Wczytano z pliku: " + filepath);
        weaponTypesFromFile.forEach(x -> {
            System.out.println(x);
            x.getWeapons().forEach(y -> System.out.println('\t' + y.toString()));
        });

        System.out.println("ZADANIE 7");
        var pool = new ForkJoinPool(2);
        pool.submit(() -> weaponTypesFromFile.parallelStream()
                .forEach(x -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(x);
                    x.getWeapons().forEach( y -> {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(y);
                    });
                })
        ).join();

        pool.shutdown();
    }
}
