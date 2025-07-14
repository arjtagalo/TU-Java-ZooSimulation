package com.example.ooput.models;

public abstract class Shop {
    protected String shopName;

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

}
