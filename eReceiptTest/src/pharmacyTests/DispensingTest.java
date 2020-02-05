package pharmacyTests;

import data.ProductID;
import org.junit.Before;
import org.junit.Test;
import pharmacy.Dispensing;
import pharmacy.MedicineDispensingLine;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class DispensingTest {

    private Dispensing dispensing;
    private MedicineDispensingLine medicineDispensingLine;
    private Date dateInit, dateFin;

    private ProductID productID;

    @Before
    public void setUp(){

        dateInit = new GregorianCalendar(2018, Calendar.JANUARY, 1).getTime();
        dateInit = new GregorianCalendar(2022, Calendar.JANUARY, 1).getTime();
        dispensing = new Dispensing((byte) 1, dateInit, dateFin);

        productID = new ProductID("upc1");

        medicineDispensingLine = new MedicineDispensingLine(productID);

        dispensing.addMedicine(medicineDispensingLine);

    }

    @Test
    public void getMedicineTest(){

        assertEquals(medicineDispensingLine, dispensing.getMedicine(productID));

    }

    @Test
    public void MedicineNotAquired(){

        MedicineDispensingLine medicine = dispensing.getMedicine(productID);

        assertFalse(medicine.isAdquired());
    }

    @Test
    public void MedicineAquired(){

        dispensing.setProductAsDispensed(productID);

        MedicineDispensingLine medicine = dispensing.getMedicine(productID);

        assertTrue(medicine.isAdquired());

    }



}