package com.example.retrofit101;

public interface MainView {

    interface Presenter {
        void getWeatherForecast(String cityName);
    }

    void initViews();

    void initListeners();

    void setWeather(String weather);
}
