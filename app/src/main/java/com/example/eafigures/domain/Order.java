package com.example.eafigures.domain;

public class Order {
    private String imgUrl;
    private String name;

    public Order(String imgUrl, String name) {
        this.imgUrl = imgUrl;
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getName() {
        return name;
    }
}
