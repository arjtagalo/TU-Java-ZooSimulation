package com.example.ooput.models.people;

import com.example.ooput.models.People;

public class Manager extends People {
    public Manager(String name) {
        super(name);
    }

    public void openZoo() {
        System.out.println(name + " has opened the zoo.");
    }

    public void closeZoo() {
        System.out.println(name + " has closed the zoo.");
    }
}
