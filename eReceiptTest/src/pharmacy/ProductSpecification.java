package pharmacy;

import data.ProductID;

import java.math.BigDecimal;

public class ProductSpecification {

    private ProductID UPCcode;
    private String description;
    private BigDecimal price;

    public ProductSpecification(ProductID UPCcode, String description, BigDecimal price) {
        this.UPCcode = UPCcode;
        this.description = description;
        this.price = price;
    }

    public ProductID getUPCcode() {
        return UPCcode;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPricce() {
        return price;
    }

    public void setUPCcode(ProductID UPCcode) {
        this.UPCcode = UPCcode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPricce(BigDecimal pricce) {
        this.price = pricce;
    }
}
