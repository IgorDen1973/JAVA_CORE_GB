package ru.geekbrains.JAVA2.lesson7even.project.model;

import ru.geekbrains.JAVA2.lesson7even.project.model.entity.Weather;

import java.io.IOException;
import java.text.ParseException;

public interface IWeatherProvider {

    Weather getCurrentWeather(String cityKey) throws IOException, ParseException;

    void getWeatherForFiveDays(String cityKey) throws IOException, ParseException;

}


