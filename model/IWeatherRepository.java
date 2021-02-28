package ru.geekbrains.JAVA2.outStanding.model;

import ru.geekbrains.JAVA2.outStanding.model.entity.Weather;

import java.util.List;

public interface IWeatherRepository {

    List<Weather> getAllData(); // метод для просмотра архива

    void saveWeatherObject (Weather weather);
}
