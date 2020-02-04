package data;

import org.testng.annotations.Test;
import org.junit.jupiter.api.BeforeEach;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HealthCardIDTest {

    private HealthCardID id;
    private String InvalidCode;

    @BeforeEach
    public void setUp(){
        InvalidCode = new String("InvalidCode");

    }

   @Test
   public void NullHealthCareID(){

       Throwable exception = assertThrows(InvalidParameterException.class, () -> {
           id = new HealthCardID(null);
       });

   }

   @Test
   public void InvalidHealthCareID(){

       Throwable exception = assertThrows(InvalidParameterException.class, () -> {
           id = new HealthCardID(InvalidCode);
       });

   }
}