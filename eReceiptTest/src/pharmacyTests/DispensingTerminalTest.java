package pharmacyTests;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import org.junit.Before;
import org.junit.Test;
import pharmacy.*;
import services.*;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DispensingTerminalTest {

    private DispensingTerminal dispensingTerminal;

    private NationalHealthService SNS = new SistemaNacionalSalut();
    private HealthCardReader cardReader = new Lector();
    private HealthCardReader badCardReader = new BadLector();

    private Dispensing dispensing;
    private PatientContr patientContr;
    private Sale sale;
    private ProductID productID;

    private ProductSpecification productSpecification;
    private HealthCardID healthCardID = new HealthCardID("ValidCode");
    private HealthCardID badHealthCardID = new HealthCardID("Not Valid Code");
    private PatientContr expectedPatientContr =  new PatientContr(new BigDecimal(50));


    @Before
    public void Setup(){

        dispensingTerminal = new DispensingTerminal(SNS, cardReader);

        Date dateInit = new GregorianCalendar(2018, Calendar.JANUARY, 1).getTime();
        Date dateFin = new GregorianCalendar(2022, Calendar.JANUARY, 1).getTime();
        dispensing = new Dispensing((byte) 1, dateInit, dateFin);

        patientContr = new PatientContr(new BigDecimal(50));
        sale= new Sale(0);
        productID = new ProductID("1");
        productSpecification = new ProductSpecification(productID);
        productSpecification.setPrice(new BigDecimal(10));

    }

    class Lector implements HealthCardReader{


        @Override
        public HealthCardID getHealthCardID() throws HealthCardException {
            return healthCardID;
        }
    }

    class BadLector implements HealthCardReader{


        @Override
        public HealthCardID getHealthCardID() throws HealthCardException {
            return badHealthCardID;
        }
    }
    class SistemaNacionalSalut implements NationalHealthService{


        @Override
        public Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException {

            if(hcID.getPersonalID().equals("Not Valid Code"))
                throw new HealthCardException("invalid card");

            return dispensing;
        }

        @Override
        public PatientContr getPatientContr(HealthCardID hcID) throws ConnectException {
            return patientContr;
        }

        @Override
        public ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException {
            if(pID.getUpc().equals("invalidUPC"))
                throw new ProductIDException("Invalid UPC");

            return productSpecification;
        }

        @Override
        public List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException {
            return Arrays.asList(dispensing);
        }
    }

    @Test
    public void getPrescriptionTest() throws NotValidePrescriptionException, HealthCardException, ConnectException {

        dispensingTerminal.getePrescription('o');

        assertEquals(dispensingTerminal.getDispensing(), dispensing);
        assertEquals(dispensingTerminal.getPatientContr(), expectedPatientContr);
    }

    @Test
    public void invalidHealthCard(){

        dispensingTerminal = new DispensingTerminal(SNS, badCardReader);

        Throwable exception = assertThrows(HealthCardException.class, () ->{

            dispensingTerminal.getePrescription('o');
        });
    }

    @Test
    public void initSaleTest(){

        dispensingTerminal.initNewSale();
        assertEquals(sale, dispensingTerminal.getSale());
    }

    @Test
    public void enterProductTest() throws SaleClosedException, NotValidePrescriptionException, HealthCardException, ConnectException {

        dispensingTerminal.getePrescription('0');
        dispensingTerminal.initNewSale();
        dispensingTerminal.enterProduct(productID);

        Sale thisSale = dispensingTerminal.getSale();
        List<ProductSaleLine> lines = thisSale.getLines();

        ProductSpecification product = new ProductSpecification(lines.get(0).prodid);
        product.setPrice(new BigDecimal(10));

        assertEquals(product, productSpecification);

    }

    @Test
    public void finalizeSaleTest() throws NotValidePrescriptionException, HealthCardException, ConnectException {

        dispensingTerminal.initNewSale();
        dispensingTerminal.getSale().setClosed();

        Throwable exception = assertThrows(SaleClosedException.class, () -> {
            dispensingTerminal.finalizeSale();
        });

    }

}