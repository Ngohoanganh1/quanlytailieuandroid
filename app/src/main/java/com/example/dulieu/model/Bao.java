package com.example.dulieu.model;

public class Bao {
     String ngayphathanh;
     int id;

    public Bao(String ngayphathanh, int id) {
        this.ngayphathanh = ngayphathanh;
        this.id = id;
    }

    public String getNgayphathanh() {
        return ngayphathanh;
    }

    public void setNgayphathanh(String ngayphathanh) {
        this.ngayphathanh = ngayphathanh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
