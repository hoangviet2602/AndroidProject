package pk_HelperClassesS;

import java.io.Serializable;

public class phonehelperS implements Serializable {

    int imageS;
    String titleS;
    String priceS;
    String rateS;
    String noteS;
    int starS;
    int star2S;
    int star3S;
    int star4S;

    public phonehelperS(int imageS, String titleS, String priceS, String rateS, String noteS, int starS, int star2S, int star3S, int star4S) {
        this.imageS = imageS;
        this.titleS = titleS;
        this.priceS = priceS;
        this.rateS = rateS;
        this.noteS = noteS;
        this.starS = starS;
        this.star2S = star2S;
        this.star3S = star3S;
        this.star4S = star4S;
    }

    public int getImageS() {
        return imageS;
    }

    public void setImageS(int imageS) {
        this.imageS = imageS;
    }

    public String getTitleS() {
        return titleS;
    }

    public void setTitleS(String titleS) {
        this.titleS = titleS;
    }

    public String getPriceS() {
        return priceS;
    }

    public void setPriceS(String priceS) {
        this.priceS = priceS;
    }

    public String getRateS() {
        return rateS;
    }

    public void setRateS(String rateS) {
        this.rateS = rateS;
    }

    public String getNoteS() {
        return noteS;
    }

    public void setNoteS(String noteS) {
        this.noteS = noteS;
    }

    public int getStarS() {
        return starS;
    }

    public void setStarS(int starS) {
        this.starS = starS;
    }

    public int getStar2S() {
        return star2S;
    }

    public void setStar2S(int star2S) {
        this.star2S = star2S;
    }

    public int getStar3S() {
        return star3S;
    }

    public void setStar3S(int star3S) {
        this.star3S = star3S;
    }

    public int getStar4S() {
        return star4S;
    }

    public void setStar4S(int star4S) {
        this.star4S = star4S;
    }
}

