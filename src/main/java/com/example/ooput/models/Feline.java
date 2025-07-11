package com.example.ooput.models;

public class Feline extends Animal {
    private String location;

    public Feline(String name, String location) {
        super(name);
        this.location = location;
    }

    @Override
    public void roam() {
        System.out.println(name + " is stalking quietly at " + location + ".");
    }

    public String getLocation() {
        return location;
    }
}
