package _17_IO_binary_file_va_serialization.bai_tap.quan_ly_san_pham_luu_ra_file_nhi_phan;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String productionDelay;
    private int price;
    private String otherDescriptions;

    public Product(String id, String name, String productionDelay, int price, String otherDescriptions) {
        this.id = id;
        this.name = name;
        this.productionDelay = productionDelay;
        this.price = price;
        this.otherDescriptions = otherDescriptions;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductionDelay() {
        return productionDelay;
    }

    public void setProductionDelay(String productionDelay) {
        this.productionDelay = productionDelay;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOtherDescriptions() {
        return otherDescriptions;
    }

    public void setOtherDescriptions(String otherDescriptions) {
        this.otherDescriptions = otherDescriptions;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", productionDelay='" + productionDelay + '\'' +
                ", price=" + price +
                ", otherDescriptions='" + otherDescriptions + '\'' +
                '}';
    }
}
