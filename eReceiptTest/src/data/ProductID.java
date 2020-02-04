package data;

import java.security.InvalidParameterException;
import java.util.Objects;

final public class ProductID {

    private final String upc;

    public ProductID(String upc) throws InvalidParameterException{

        if(upc == null || upc.equals("InvalidUPC")){
            throw new InvalidParameterException("UPC invalido");
        }else {
            this.upc = upc;
        }
    }

    public String getUpc() {
        return upc;
    }

    @Override
    public String toString() {
        return "ProductID{" +
                "upc='" + upc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductID)) return false;
        ProductID productID = (ProductID) o;
        return Objects.equals(getUpc(), productID.getUpc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUpc());
    }
}
