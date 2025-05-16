package com.in.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirportsTest {

    @Test
    public void testSetter(){
        Airports airports=new Airports();
        airports.setCity("sitamarhi");
        assertEquals("sitamarhi", airports.getCity());
    }

}
