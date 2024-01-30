package com.example.learningandroid.model;

public class Cat_crud {
    private int img;
    private String name, description;
    private double price;

    public Cat_crud() {
    }

    public Cat_crud(int img, String name, String description, double price) {
        this.img = img;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
