package pk_cart;

public class Cart {
    public int image;
    public int imgplus;
    public int imgminus;
    public String quanlity;
    public String delete;
    public String tittle;
    public float price;
    public String note;

    public Cart(int image, int imgplus, int imgminus, String quanlity, String delete, String tittle, float price, String note) {
        this.image = image;
        this.imgplus = imgplus;
        this.imgminus = imgminus;
        this.quanlity = quanlity;
        this.delete = delete;
        this.tittle = tittle;
        this.price = price;
        this.note = note;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImgplus() {
        return imgplus;
    }

    public void setImgplus(int imgplus) {
        this.imgplus = imgplus;
    }

    public int getImgminus() {
        return imgminus;
    }

    public void setImgminus(int imgminus) {
        this.imgminus = imgminus;
    }

    public String getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(String quanlity) {
        this.quanlity = quanlity;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

