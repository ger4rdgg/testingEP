package pharmacyTests;

import data.PatientContr;
import data.ProductID;
import org.junit.Before;
import org.junit.Test;
import pharmacy.ProductSaleLine;
import pharmacy.Sale;
import pharmacy.SaleClosedException;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSaleLineTest {


    private ProductSaleLine Expected;
    private PatientContr patientContr;
    private ProductID productID;

    private BigDecimal price;

    private Sale sale;

    @Before
    public void setUp(){

        productID = new ProductID("validId");
        Expected = new ProductSaleLine(productID, new BigDecimal(10));

        price= new BigDecimal(10);

        sale = new Sale(1);
        patientContr = new PatientContr(new BigDecimal(100)); // la contribucio es del 100% es a dir paga el total del preu
    }

    @Test
    public void ProductSaleLineTest() throws SaleClosedException {

        sale.addLine(productID, price, patientContr);
        ProductSaleLine result = sale.getLines().get(0);
        assertEquals(Expected, result);

    }

}
