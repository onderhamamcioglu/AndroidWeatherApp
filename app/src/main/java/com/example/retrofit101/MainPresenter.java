package com.example.retrofit101;

import androidx.annotation.NonNull;

import com.example.retrofit101.model.WeatherResponse;
import com.example.retrofit101.network.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainView.Presenter {

    private final MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        bind();
    }

    public void bind() {
        if (true) { // Some conditions
            this.mainView.initViews();
            this.mainView.initListeners();
        }
    }

    @Override
    public void getWeatherForecast(String cityName) {
        WeatherService.getInstance()
                .getRepository()
                .getCurrentWeatherData(cityName, "d6032e15f5b14eaf0eeea8f8d5713d16", "metric")
                .enqueue(new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {
                        if (response.code() == 200) {
                            WeatherResponse weatherResponse = response.body();
                            assert weatherResponse != null;
                            mainView.setWeather("Temperature: " + weatherResponse.getMain().getTemp() + "\nHumidity: " + weatherResponse.getMain().getHumidity());
                        } else {
                            mainView.setWeather("CODE: " + response.code());
                            System.out.println(call.request().url());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                        mainView.setWeather("ERR: " + t.getMessage());
                        System.out.println(call.request().url());
                    }
                });
    }
}
