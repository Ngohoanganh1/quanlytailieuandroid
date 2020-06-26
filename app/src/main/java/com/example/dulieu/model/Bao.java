package com.example.dulieu.model;

public class Bao {
     String Ngayphathanh;
     int id;

    public Bao(String ngayphathanh, int id) {
        Ngayphathanh = ngayphathanh;
        this.id = id;
    }

    public String getNgayphathanh() {
        return Ngayphathanh;
    }

    public int getId() {
        return id;
    }

    public void setNgayphathanh(String ngayphathanh) {
        Ngayphathanh = ngayphathanh;
    }

    public void setId(int id) {
        this.id = id;
    }
}
