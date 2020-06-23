package com.example.dulieu.model;

public class Sach {
    String Tentacgia,Masach;
    int id;

    public Sach(String tentacgia, String Masach, int id) {
        Tentacgia = tentacgia;
        this.Masach = Masach;
        this.id = id;
    }

    public String getTentacgia() {
        return Tentacgia;
    }

    public void setTentacgia(String tentacgia) {
        Tentacgia = tentacgia;
    }

    public String getMasach() {
        return Masach;
    }

    public void setMasach(String masach) {
        this.Masach = masach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
