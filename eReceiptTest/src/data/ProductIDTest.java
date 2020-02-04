package data;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductIDTest {


    private ProductID UPC;
    private String invalidUPC;

    @BeforeEach
    public void setUP(){

        invalidUPC = new String("InvalidUPC");
    }


    @Test
    public void NullProductID(){

        Throwable exception = assertThrows(InvalidParameterException.class, () -> {
            UPC = new ProductID(null);
        });

    }
    @Test
    public void InvalidProductID(){

        Throwable exception = assertThrows(InvalidParameterException.class, () -> {
            UPC = new ProductID(invalidUPC);
        });

    }
}