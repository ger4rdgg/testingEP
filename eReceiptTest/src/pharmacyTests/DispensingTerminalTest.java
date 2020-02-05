package pharmacyTests;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;
import org.junit.Before;
import pharmacy.Dispensing;
import pharmacy.ProductSpecification;
import services.HealthCardException;
import services.NationalHealthService;
import services.NotValidePrescriptionException;
import services.ProductIDException;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DispensingTerminalTest {

    private NationalHealthService SNS = new SistemaNacionalSalut();
    private Dispensing dispensing;
    private PatientContr patientContr;

    private ProductSpecification productSpecification;

    @Before
    public void Setup(){

        Date dateInit = new GregorianCalendar(2018, Calendar.JANUARY, 1).getTime();
        Date dateFin = new GregorianCalendar(2022, Calendar.JANUARY, 1).getTime();
        dispensing = new Dispensing((byte) 1, dateInit, dateFin);

        patientContr = new PatientContr(new BigDecimal(50));


    }

    class SistemaNacionalSalut implements NationalHealthService{


        @Override
        public Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException {

            if(hcID.getPersonalID().equals("invalidID"))
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

}