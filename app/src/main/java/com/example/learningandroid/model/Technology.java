package com.example.learningandroid.model;

public class Technology {
    private int img;
    private String name, sub, describe;

    public Technology(int img, String name, String sub, String describe) {
        this.img = img;
        this.name = name;
        this.sub = sub;
        this.describe = describe;
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

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
