package pharmacy;

import data.ProductID;

import java.math.BigDecimal;
import java.util.Objects;

public  class ProductSaleLine{

    public ProductID prodid;
    public BigDecimal parcialPrice;

    public ProductSaleLine(ProductID prodid, BigDecimal parcialPrice) {
        this.prodid = prodid;
        this.parcialPrice = parcialPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductSaleLine)) return false;
        ProductSaleLine that = (ProductSaleLine) o;
        return Objects.equals(prodid, that.prodid) &&
                Objects.equals(parcialPrice, that.parcialPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodid, parcialPrice);
    }
}