package pharmacy;

import data.ProductID;

import java.math.BigDecimal;

public  class ProductSaleLine{

    public ProductID prodid;
    public BigDecimal parcialPrice;

    public ProductSaleLine(ProductID prodid, BigDecimal parcialPrice) {
        this.prodid = prodid;
        this.parcialPrice = parcialPrice;
    }


}