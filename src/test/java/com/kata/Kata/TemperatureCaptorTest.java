package com.kata.Kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureCaptorTest {

    @Test
    void create() {
        TemperatureCaptor temperatureCaptor = new TemperatureCaptor();
    }

    @Test
    void getTemperature() {
        TemperatureCaptor temperatureCaptor = new TemperatureCaptor(10);
        assertEquals("10C", temperatureCaptor.getTemperatureInCelcius());
    }
}
