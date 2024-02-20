package com.example.learningandroid.model;

import android.app.DatePickerDialog;

public class CongViec {
    private String name, content, date;
    private boolean gender;

    public CongViec() {
    }

    public CongViec(String name, String content, String date, boolean gender) {
        this.name = name;
        this.content = content;
        this.date = date;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
