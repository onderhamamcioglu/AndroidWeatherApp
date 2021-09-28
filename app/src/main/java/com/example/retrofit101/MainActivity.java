package com.example.retrofit101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainView {

    private Button submitButton;
    private TextView cityNameText;
    private TextView weatherForecast;


    private MainView.Presenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
    }

    @Override
    public void initViews() {
        submitButton = findViewById(R.id.button);
        cityNameText = findViewById(R.id.et_simple);
        weatherForecast = findViewById(R.id.textView);
    }

    @Override
    public void initListeners() {
        submitButton.setOnClickListener(view -> {
            mainPresenter.getWeatherForecast(cityNameText.getText().toString());
        });
    }

    @Override
    public void setWeather(String weather) {
        weatherForecast.setText(weather);
    }
}
