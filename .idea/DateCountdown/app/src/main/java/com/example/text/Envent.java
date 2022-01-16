package com.example.phamxuantoan;

public class Envent {
    String title;
    String envent;
    String Sdate;
    String Fdate;
    String date;

    public Envent(String title, String envent, String sdate, String fdate, String date) {
        this.title = title;
        this.envent = envent;
        Sdate = sdate;
        Fdate = fdate;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnvent() {
        return envent;
    }

    public void setEnvent(String envent) {
        this.envent = envent;
    }

    public String getSdate() {
        return Sdate;
    }

    public void setSdate(String sdate) {
        Sdate = sdate;
    }

    public String getFdate() {
        return Fdate;
    }

    public void setFdate(String fdate) {
        Fdate = fdate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
