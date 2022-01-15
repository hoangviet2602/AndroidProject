package com.example.chitietsanpham.HelperClasses;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

public class phonehelper {

    int image;
    String title;
    String price;
    String rate;
    String note;
    int star;
    int star2;
    int star3;
    int star4;

    public phonehelper(int image, String title, String price, String rate, String note, int star, int star2, int star3, int star4) {
        this.image = image;
        this.title = title;
        this.price = price;
        this.rate = rate;
        this.note = note;
        this.star = star;
        this.star2 = star2;
        this.star3 = star3;
        this.star4 = star4;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getRate() {
        return rate;
    }

    public String getNote() {
        return note;
    }

    public int getStar() {
        return star;
    }

    public int getStar2() {
        return star2;
    }

    public int getStar3() {
        return star3;
    }

    public int getStar4() {
        return star4;
    }


}

