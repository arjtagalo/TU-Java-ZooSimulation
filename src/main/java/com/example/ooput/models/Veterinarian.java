package com.example.ooput.models;

public class Veterinarian extends People {
    public Veterinarian(String name) {
        super(name);
    }

    public void heal() {
        System.out.println(name + " is healing a sick animal.");
    }

    public void lecture() {
        System.out.println(name + " is giving a lecture on animal care.");
    }
}
