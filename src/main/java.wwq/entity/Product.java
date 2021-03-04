package entity;

public class Product {
    private int product_id;
    private String product_name;
    private String product_description;
    private int product_price;
    private int product_stock;
    private int product_fid;
    private int product_cid;
    private String product_filename;

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_description='" + product_description + '\'' +
                ", product_price=" + product_price +
                ", product_stock=" + product_stock +
                ", product_fid=" + product_fid +
                ", product_cid=" + product_cid +
                ", product_filename='" + product_filename + '\'' +
                '}';
    }



    public Product(int product_id, String product_name, String product_description, int product_price, int product_stock, int product_fid, int product_cid, String product_filename) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_price = product_price;
        this.product_stock = product_stock;
        this.product_fid = product_fid;
        this.product_cid = product_cid;
        this.product_filename = product_filename;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public int getProduct_stock() {
        return product_stock;
    }

    public void setProduct_stock(int product_stock) {
        this.product_stock = product_stock;
    }

    public int getProduct_fid() {
        return product_fid;
    }

    public void setProduct_fid(int product_fid) {
        this.product_fid = product_fid;
    }

    public int getProduct_cid() {
        return product_cid;
    }

    public void setProduct_cid(int product_cid) {
        this.product_cid = product_cid;
    }

    public String getProduct_filename() {
        return product_filename;
    }

    public void setProduct_filename(String product_filename) {
        this.product_filename = product_filename;
    }
}
