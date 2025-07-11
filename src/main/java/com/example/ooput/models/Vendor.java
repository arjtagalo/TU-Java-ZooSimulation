package com.example.ooput.models;

public class Vendor extends People {
    public Vendor(String name) {
        super(name);
    }

    public void sell() {
        System.out.println(name + " is selling products to visitors.");
    }
}
