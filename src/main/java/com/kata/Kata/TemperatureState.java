package com.kata.Kata;

public class TemperatureState {
    private int temperature;
    private SensorStateEnum state;

    public TemperatureState(int temperature, SensorStateEnum state) {
        this.temperature = temperature;
        this.state = state;
    }
}
