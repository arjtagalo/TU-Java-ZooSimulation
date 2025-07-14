package com.example.ooput.utils;

import com.example.ooput.models.Animal;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private static final List<Animal> sickAnimals = new ArrayList<>();
    private static final List<Animal> healedAnimals = new ArrayList<>();

    public static void admitAnimal(Animal animal) {
        if (!sickAnimals.contains(animal)) {
            sickAnimals.add(animal);
            System.out.println(animal.name + " has been admitted to the hospital.");
        } else {
            System.out.println(animal.name + " is already admitted.");
        }
    }

    public static void healAllAnimals(String vetName) {
        if (sickAnimals.isEmpty()) {
            System.out.println("No sick animals to heal.");
            return;
        }

        System.out.println("\n" + vetName + " is healing all sick animals...");
        for (Animal animal : sickAnimals) {
            System.out.println("- " + animal.name + " has been healed.");
            healedAnimals.add(animal);
        }
        sickAnimals.clear();
    }

    public static List<Animal> getSickAnimals() {
        return sickAnimals;
    }

    public static List<Animal> getHealedAnimals() {
        return healedAnimals;
    }
}
