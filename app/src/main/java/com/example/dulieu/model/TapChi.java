package com.example.dulieu.model;

public class TapChi {
     String Sophathanh,thangphathanh;
    int id;

    public TapChi(String sophathanh, String thangphathanh, int id) {
        Sophathanh = sophathanh;
        this.thangphathanh = thangphathanh;
        this.id = id;
    }

    public String getSophathanh() {
        return Sophathanh;
    }

    public void setSophathanh(String sophathanh) {
        Sophathanh = sophathanh;
    }

    public String getThangphathanh() {
        return thangphathanh;
    }

    public void setThangphathanh(String thangphathanh) {
        this.thangphathanh = thangphathanh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


