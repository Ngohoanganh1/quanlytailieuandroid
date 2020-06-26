package com.example.dulieu.model;

public class TapChi {
    private String Sophathanh;
    private String thangphathanh;
    private int id;

    public TapChi(String sophathanh, String thangphathanh, int id) {
        Sophathanh = sophathanh;
        this.thangphathanh = thangphathanh;
        this.id = id;
    }

    public void setSophathanh(String sophathanh) {
        Sophathanh = sophathanh;
    }

    public void setThangphathanh(String thangphathanh) {
        this.thangphathanh = thangphathanh;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSophathanh() {
        return Sophathanh;
    }

    public String getThangphathanh() {
        return thangphathanh;
    }

    public int getId() {
        return id;
    }
}


