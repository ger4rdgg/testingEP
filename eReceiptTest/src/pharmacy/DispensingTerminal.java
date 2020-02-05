package pharmacy;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import services.HealthCardException;
import services.HealthCardReader;
import services.NationalHealthService;
import services.NotValidePrescriptionException;

import java.math.BigDecimal;
import java.net.ConnectException;

public class DispensingTerminal {

    private NationalHealthService SNS;
    private HealthCardReader healthCardReader;

    private Dispensing dispensing;
    private Sale sale;

    private PatientContr patientContr;

    public static int code = 0;

    public DispensingTerminal(NationalHealthService SNS, HealthCardReader healthCardReader) {
        this.SNS = SNS;
        this.healthCardReader = healthCardReader;
    }

    public void getePrescription(char option) throws HealthCardException, NotValidePrescriptionException, ConnectException {

        HealthCardID card = healthCardReader.getHealthCardID();
        dispensing = SNS.getePrescription(card);
        patientContr = SNS.getPatientContr(card);

    }

    public void initNewSale(){

        sale = new Sale(code);
        code ++;

    }

    public void enterProduct(ProductID productID) throws SaleClosedException {

        ProductSpecification product = new ProductSpecification(productID);
        product.setPrice(new BigDecimal(10));
        sale.addLine(productID, product.getPrice(), patientContr);
    }

    public void finalizeSale() throws SaleClosedException {

        sale.CalculateFinalAmount();
        sale.setClosed();
    }

    public void realizePayment(BigDecimal quantity){

        System.out.println("pago realizado");
    }

    public void realizePayment(){

        System.out.println("Pagado");

    }
    public void printNextDispensingSheet(){

        System.out.println("Hoja imprimida");

    }
}
