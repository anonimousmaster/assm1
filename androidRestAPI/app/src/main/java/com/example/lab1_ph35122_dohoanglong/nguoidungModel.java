package com.example.lab1_ph35122_dohoanglong;

public class nguoidungModel {
    private String _id;
    private String ten;
    private int tuoi;
    private String diachi;
    private double sodienthoai;

    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public int getTuoi() {
        return tuoi;
    }
    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    public String getDiachi() {
        return diachi;
    }
    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    public double getSodienthoai() {
        return sodienthoai;
    }
    public void setSodienthoai(double sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public nguoidungModel(String _id, String ten, int tuoi, String diachi, double sodienthoai) {
        this._id = _id;
        this.ten = ten;
        this.tuoi = tuoi;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
    }
}
