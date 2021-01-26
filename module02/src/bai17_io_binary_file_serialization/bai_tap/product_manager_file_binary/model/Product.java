package bai17_io_binary_file_serialization.bai_tap.product_manager_file_binary.model;

public class Product {
    private String idProduct;
    private String nameProduct;
    private String brandProduct;
    private float priceProduct;
    private String descriptionProduct;

    public Product() {
    }

    public Product(String idProduct, String nameProduct, String brandProduct, float priceProduct, String descriptionProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.brandProduct = brandProduct;
        this.priceProduct = priceProduct;
        this.descriptionProduct = descriptionProduct;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getBrandProduct() {
        return brandProduct;
    }

    public void setBrandProduct(String brandProduct) {
        this.brandProduct = brandProduct;
    }

    public float getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(float priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    @Override
    public String toString() {
        return "ID: " + idProduct +
                ", Name: " + nameProduct +
                ", Brand" + brandProduct +
                ", Price: " + priceProduct +
                ", Description: " + descriptionProduct;
    }

    public String getInfo() {
        return idProduct + "," + nameProduct + "," + brandProduct + "," + priceProduct + "," + descriptionProduct;
    }
}
