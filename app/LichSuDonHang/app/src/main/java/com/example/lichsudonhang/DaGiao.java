package com.example.lichsudonhang;

public class DaGiao {

    int image;
    String title;
    String soluong;
    String tongtien;
    

    public DaGiao(int image, String title, String soluong, String tongtien) {
        this.image = image;
        this.title = title;
        this.soluong = soluong;
        this.tongtien = tongtien;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getTongTien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }
}
