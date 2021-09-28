package com.example.retrofit101.network;

import com.example.retrofit101.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherRepository {

    @GET("data/2.5/weather")
    Call<WeatherResponse> getCurrentWeatherData(@Query("q") String city, @Query("APPID") String app_id, @Query("units") String unit);
}
