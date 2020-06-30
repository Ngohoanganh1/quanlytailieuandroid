package com.example.dulieu.model;

public class Bao {
     String sosanpham;
     String masanpham;
     String soluong;
     String dongia;
     String hansudung;
     String tensanpham;
     String loaisanpham;
      int id;

    public Bao(String sosanpham, String masanpham, String soluong, String dongia, String hansudung, String tensanpham, String loaisanpham, int id) {
        this.sosanpham = sosanpham;
        this.masanpham = masanpham;
        this.soluong = soluong;
        this.dongia = dongia;
        this.hansudung = hansudung;
        this.tensanpham = tensanpham;
        this.loaisanpham = loaisanpham;
        this.id = id;
    }

    public String getSosanpham() {
        return sosanpham;
    }

    public void setSosanpham(String sosanpham) {
        this.sosanpham = sosanpham;
    }

    public String getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(String masanpham) {
        this.masanpham = masanpham;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    public String getHansudung() {
        return hansudung;
    }

    public void setHansudung(String hansudung) {
        this.hansudung = hansudung;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getLoaisanpham() {
        return loaisanpham;
    }

    public void setLoaisanpham(String loaisanpham) {
        this.loaisanpham = loaisanpham;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
