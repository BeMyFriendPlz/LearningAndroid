package com.example.learningandroid.model;

public class NhanVien {
    private String ma, ten;
    private boolean gioiTinh, isCheck;

    public NhanVien() {
    }

    public NhanVien(String ma, String ten, boolean gioiTinh, boolean isCheck) {
        this.ma = ma;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.isCheck = isCheck;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
