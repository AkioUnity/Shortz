package model;


public class Channel_Model {
    Integer imageView1;
    String txtprice,txtproductname,txtreviews;

    public Integer getImageView1() {
        return imageView1;
    }

    public void setImageView1(Integer imageView1) {
        this.imageView1 = imageView1;
    }

    public String getTxtprice() {
        return txtprice;
    }

    public void setTxtprice(String txtprice) {
        this.txtprice = txtprice;
    }

    public String getTxtproductname() {
        return txtproductname;
    }

    public void setTxtproductname(String txtproductname) {
        this.txtproductname = txtproductname;
    }

    public String getTxtreviews() {
        return txtreviews;
    }

    public void setTxtreviews(String txtreviews) {
        this.txtreviews = txtreviews;
    }

    public Channel_Model(Integer imageView1) {
        this.imageView1 = imageView1;
//        this.txtprice = txtprice;
//        this.txtproductname = txtproductname;
//        this.txtreviews = txtreviews;
    }
}
