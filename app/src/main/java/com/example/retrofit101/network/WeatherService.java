package com.example.retrofit101.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Singleton Pattern
public class WeatherService {

    private static volatile WeatherService instance;
    private final WeatherRepository repository;

    private WeatherService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        repository = retrofit.create(WeatherRepository.class);
    }

    public static synchronized WeatherService getInstance() {
        if (instance == null) {
            instance = new WeatherService();
        }
        return instance;
    }

    public WeatherRepository getRepository() {
        return repository;
    }
}
