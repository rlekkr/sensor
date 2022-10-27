package com.kata.Kata;

import java.util.ArrayList;
import java.util.List;

public class Sensor {

    private List<TemperatureState> historics;

    private static int HISTORY_MAX_LENGTH = 15;

    private int currentIndex = 0;

    private TemperatureInterval HOTInterval;
    private TemperatureInterval COLDInterval;

    public Sensor() {
        this.historics = new ArrayList<>();
    }

    public SensorStateEnum getState(TemperatureCaptor temperatureCaptor) {
        SensorStateEnum state;
        if (temperatureCaptor == null) {
            throw new IllegalArgumentException("Temperature Captor should be not null");
        }
        if (temperatureCaptor.getTemperature() >= this.HOTInterval.getRange().getMax()) {
            state = SensorStateEnum.HOT;
        } else if (temperatureCaptor.getTemperature() < this.COLDInterval.getRange().getMax()) {
            state = SensorStateEnum.COLD;
        } else {
            state = SensorStateEnum.WARM;
        }
        this.currentIndex++;
        if (this.currentIndex <= HISTORY_MAX_LENGTH) {
            TemperatureState temperatureState = new TemperatureState(temperatureCaptor.getTemperature(), state);
            this.historics.add(temperatureState);
        }
        return state;
    }

    public List<TemperatureState> getHistoric() {
        return this.historics.size() > 0 ? this.historics.subList(0, 15) : this.historics;
    }

    public void setHOTInterval(TemperatureInterval hotInterval) {
        this.HOTInterval = hotInterval;
    }

    public void setCOLDInterval(TemperatureInterval coldInterval) {
        this.COLDInterval = coldInterval;
    }
}
