package com.example.ooput.models;

public class Handler extends People {
    public Handler(String name) {
        super(name);
    }

    public void feed() {
        System.out.println(name + " is feeding the animals.");
    }

    public void exercise() {
        System.out.println(name + " is exercising the animals.");
    }

    public void examine() {
        System.out.println(name + " is examining the animals.");
    }
}
