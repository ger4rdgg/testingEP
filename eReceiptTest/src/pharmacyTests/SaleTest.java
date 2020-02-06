package pharmacyTests;

import data.PatientContr;
import data.ProductID;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import pharmacy.Sale;
import pharmacy.SaleClosedException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {

    private Sale sale;

    private ProductID prodID;
    private PatientContr contr;
    private BigDecimal price;

    @Before
    public void setUP(){
        sale = new Sale(1);

        prodID = new ProductID("validID");
        contr = new PatientContr(new BigDecimal(50));
        price = new BigDecimal(10);
    }

    @Test
    public void addLineTest() throws SaleClosedException {

        assertFalse(sale.isClosed());

        sale.addLine(prodID, price,contr);
        sale.CalculateFinalAmount();
        BigDecimal finalAmount = sale.getAmount();

        assertEquals(new BigDecimal(5).multiply(new BigDecimal(1.21)), finalAmount);

    }

    @Test
    public void isClosedTest(){

        sale.setClosed();
        assertTrue(sale.isClosed());

    }

    @Test
    public void  closedExceptionTest(){
        sale.setClosed();
        Throwable exception = assertThrows(SaleClosedException.class, () -> {
            sale.addLine(prodID, price,contr);
        });

    }



}