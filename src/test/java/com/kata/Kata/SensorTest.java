package com.kata.Kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class SensorTest {
    private Sensor sensor;

    @BeforeEach
    void setup() {
        sensor = new Sensor();
        TemperatureInterval hotInterval = new TemperatureInterval(new TemperatureRange(0, 40), SensorStateEnum.HOT);
        sensor.setHOTInterval(hotInterval);
        TemperatureInterval coldInterval = new TemperatureInterval(new TemperatureRange(-50, 22), SensorStateEnum.COLD);
        sensor.setCOLDInterval(coldInterval);
    }

    @Test
    void hasNotTemperatureCaptor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Sensor().getState(null);
        });
    }

    @Test
    void hotTemperatureCaptor() {
        checkState(40, 50, SensorStateEnum.HOT);
    }

    @Test
    void coldTemperatureCaptor() {
        checkState(-40, 22, SensorStateEnum.COLD);
    }

    @Test
    void warmTemperatureCaptor() {
        checkState(22, 40, SensorStateEnum.WARM);
    }

    @Test
    void getTemperatureStateNoHistoric() {
        List<TemperatureState> historics = sensor.getHistoric();
        Assertions.assertTrue(historics.isEmpty());
    }

    @Test
    void getTemperatureStateHistoricLessThan15() {
        IntStream.range(0, 15).mapToObj(TemperatureCaptor::new).forEach(temperatureCaptor -> {
            sensor.getState(temperatureCaptor);
        });
        List<TemperatureState> historics = sensor.getHistoric();
        Assertions.assertEquals(15, historics.size());
    }

    @Test
    void getTemperatureStateHistoricMoreThan15() {
        IntStream.range(0, 16).mapToObj(TemperatureCaptor::new).forEach(temperatureCaptor -> {
            sensor.getState(temperatureCaptor);
        });
        List<TemperatureState> historics = sensor.getHistoric();
        Assertions.assertEquals(15, historics.size());
    }

    private void checkState(int minimum, int maximum, SensorStateEnum expectedState) {
        IntStream.range(minimum, maximum).mapToObj(TemperatureCaptor::new).forEach(temperatureCaptor -> {
            Assertions.assertEquals(expectedState, sensor.getState(temperatureCaptor));
        });
    }

}
