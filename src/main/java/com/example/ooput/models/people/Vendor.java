package com.example.ooput.models.people;

import com.example.ooput.models.People;

public class Vendor extends People {
    public Vendor(String name) {
        super(name);
    }

    public void sell() {
        System.out.println(name + " is selling products to visitors.");
    }
}
