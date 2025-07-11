package com.example.ooput.models.animal;

import com.example.ooput.models.Animal;

import java.util.ArrayList;
import java.util.List;

public class Feline extends Animal {
    private String location;
    private static List<Feline> felineAnimals = null;

    public Feline(String name, String location) {
        super(name);
        this.location = location;
    }

    public Feline(String name){
        super(name);
    }

    public static List<Feline> getAllFeline(){
        if (felineAnimals == null) {
            felineAnimals = new ArrayList<>();

            felineAnimals.add(new Feline("Tiger"));
            felineAnimals.add(new Feline("Lion"));
            felineAnimals.add(new Feline("Cheetah"));
        }
        return felineAnimals;
    }

    @Override
    public void makeSound() {
        switch (name.toLowerCase()) {
            case "lion" -> System.out.println(name + " roars fiercely!");
            case "tiger" -> System.out.println(name + " growls deeply!");
            case "cheetah" -> System.out.println(name + " snarls softly!");
            default -> System.out.println(name + " makes a feline sound.");
        }
    }


    @Override
    public void roam() {
        System.out.println(name + " is stalking quietly at " + location + ".");
    }

    public String getLocation() {
        return location;
    }
}
