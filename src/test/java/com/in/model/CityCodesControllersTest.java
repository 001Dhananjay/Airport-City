package com.in.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityCodesControllersTest {
    @Test
    public void setterMethodTest(){
        CityCodes cityCodes=new CityCodes();
        cityCodes.setCity("patna");
        assertEquals("patna",cityCodes.getCity());
    }
}
