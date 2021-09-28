package com.example.retrofit101.model;

public class WeatherResponseMain {
    /*
        "temp": 26.68,
        "feels_like": 26.68,
        "temp_min": 25.04,
        "temp_max": 27.09,
        "pressure": 1015,
        "humidity": 41
     */
    private double temp;
    private int humidity;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
