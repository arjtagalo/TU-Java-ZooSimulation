package com.example.ooput.models;

public abstract class Animal {
    protected String name;
    protected String animalType;

    public Animal(String name){
        this.name = name;
        this.animalType = animalType;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getName() {
        return name;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void makeSound() {
        //System.out.println(name + "");
    }

}
