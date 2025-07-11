package com.example.ooput.models;

public class Pachyderm extends Animal {
    private String location;

    public Pachyderm(String name, String location) {
        super(name);
        this.location = location;
    }

    @Override
    public void roam() {
        System.out.println(name + " is roaming slowly at " + location + ".");
    }

    public String getLocation() {
        return location;
    }
}