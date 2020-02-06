package dataTests;

import data.PatientContr;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PatientContrTest {

    public PatientContr pc;
    public BigDecimal invalid1;
    public BigDecimal invalid2;

    @BeforeEach
    public void setUp(){

        invalid1 = new BigDecimal(-1);
        invalid2 = new BigDecimal(110);

    }

    @Test
    public void NegativeAportation(){

        Throwable exception = assertThrows(InvalidParameterException.class, () ->{
            pc = new PatientContr(invalid1);
        });
    }

    @Test
    public void HigherThan100Aportation(){

        Throwable exception = assertThrows(InvalidParameterException.class, () ->{
            pc = new PatientContr(invalid2);
        });
    }

    @Test
    public void NullAportation(){

        Throwable exception = assertThrows(InvalidParameterException.class, () ->{
            pc = new PatientContr(null);
        });
    }



}