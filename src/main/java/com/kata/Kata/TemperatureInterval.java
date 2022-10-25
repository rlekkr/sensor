package com.kata.Kata;

public class TemperatureInterval {
    private TemperatureRange range;
    private SensorStateEnum state;

    public TemperatureInterval(TemperatureRange range, SensorStateEnum state) {
        this.range = range;
        this.state = state;
    }

    public TemperatureRange getRange() {
        return range;
    }

    public SensorStateEnum getState() {
        return state;
    }
}
