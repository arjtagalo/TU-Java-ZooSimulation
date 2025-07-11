package com.example.ooput.models.shop;

import com.example.ooput.models.Shop;

public class Ticket extends Shop {
    private final String code;
    private final String name;
    private final int age;
    private final String type;
    private final double price;

    public Ticket(String name, int age, String type, double price, String code) {
        super("Zoo Ticket Shop");
        this.name = name;
        this.age = age;
        this.type = type;
        this.price = price;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

