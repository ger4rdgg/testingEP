package pharmacy;

import data.ProductID;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductSpecification)) return false;
        ProductSpecification that = (ProductSpecification) o;
        return Objects.equals(getUPCcode(), that.getUPCcode()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUPCcode(), getDescription(), getPrice());
    }
}
