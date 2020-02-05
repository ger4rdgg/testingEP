package pharmacy;

import data.ProductID;

import java.math.BigDecimal;

public class ProductSpecification {

    private ProductID UPCcode;
    private String description;
    private BigDecimal price;

    public ProductSpecification(ProductID UPCcode) {
        this.UPCcode = UPCcode;
    }

    public ProductID getUPCcode() {
        return UPCcode;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setUPCcode(ProductID UPCcode) {
        this.UPCcode = UPCcode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
