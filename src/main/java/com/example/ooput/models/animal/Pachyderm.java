package com.example.ooput.models.animal;

import com.example.ooput.models.Animal;

import java.util.ArrayList;
import java.util.List;

public class Pachyderm extends Animal {
    private String location;
    private static List<Pachyderm> pachydermAnimals = null;

    public Pachyderm(String name, String location) {
        super(name);
        this.location = location;
    }

    public Pachyderm(String name) {
        super(name);
    }

    public static List<Pachyderm> getAllPachyderm(){
        if (pachydermAnimals == null) {
            pachydermAnimals = new ArrayList<>();

            pachydermAnimals.add(new Pachyderm("Rhino"));
            pachydermAnimals.add(new Pachyderm("Elephant"));
            pachydermAnimals.add(new Pachyderm("Hippo"));
        }
        return pachydermAnimals;
    }

    @Override
    public void makeSound() {
        switch (name.toLowerCase()) {
            case "elephant" -> System.out.println(name + " trumpets loudly!");
            case "rhino" -> System.out.println(name + " snorts aggressively!");
            case "hippo" -> System.out.println(name + " grunts and bellows!");
            default -> System.out.println(name + " makes a heavy sound.");
        }
    }

    @Override
    public void roam() {
        System.out.println(name + " is roaming slowly at " + location + ".");
    }

    public String getLocation() {
        return location;
    }
}