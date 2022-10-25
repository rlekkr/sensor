package com.kata.Kata;

public class TemperatureCaptor {
    private int temperature;

    public TemperatureCaptor(int temperature) {
        this.temperature = temperature;
    }

    public TemperatureCaptor() {

    }

    public String getTemperatureInCelcius() {
        return this.temperature + "C";
    }


    public int getTemperature() {
        return this.temperature;
    }
}
