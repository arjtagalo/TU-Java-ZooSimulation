package com.example.ooput.models.animal;

import com.example.ooput.models.Animal;

public class Bird extends Animal {
    private String location;

    public Bird(String name, String location) {
        super(name);
        this.location = location;
    }

    @Override
    public void roam() {
        System.out.println(name + " is flying around " + location + ".");
    }

    public String getLocation() {
        return location;
    }
}