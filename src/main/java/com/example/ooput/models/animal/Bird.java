package com.example.ooput.models.animal;

import com.example.ooput.models.Animal;

import java.util.ArrayList;
import java.util.List;

public class Bird extends Animal {
    private String location;
    private static List<Bird> birdAnimals = null;

    public Bird(String name, String location) {
        super(name);
        this.location = location;
    }

    public Bird(String name) {
        super(name);
    }

    public static List<Bird> getAllBird(){
        if (birdAnimals == null) {
            birdAnimals = new ArrayList<>();

            birdAnimals.add(new Bird("Parrot"));
            birdAnimals.add(new Bird("Falcon"));
            birdAnimals.add(new Bird("Owl"));
        }
        return birdAnimals;
    }

    @Override
    public void makeSound() {
        switch (name.toLowerCase()) {
            case "parrot" -> System.out.println(name + " squawks loudly!");
            case "falcon" -> System.out.println(name + " screeches!");
            case "owl" -> System.out.println(name + " hoots cutely!");
            default -> System.out.println(name + " chirps.");
        }
    }


    @Override
    public void roam() {
        System.out.println(name + " is flying around " + location + ".");
    }

    public String getLocation() {
        return location;
    }
}