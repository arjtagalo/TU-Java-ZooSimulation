package com.example.ooput.models;

public abstract class People {
    protected String name;
    protected String location;

    public People(String name) {
        this.name = name;
        this.location = "Entrance";
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void goTo(String newLocation) {
        this.location = newLocation;
        System.out.println(name + " moved to " + location + ".");
    }

    @Override
    public String toString() {
        return "- " + name + " (" + this.getClass().getSimpleName() + ")";
    }
}
