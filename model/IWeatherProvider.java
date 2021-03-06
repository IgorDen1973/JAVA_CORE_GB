package ru.geekbrains.JAVA2.lesson7even.project.model;

import java.io.IOException;
import java.text.ParseException;

public interface IWeatherProvider {
    void getCurrentWeather(String cityKey) throws IOException, ParseException;

    void getWeatherForFiveDays(String cityKey) throws IOException, ParseException;

}


