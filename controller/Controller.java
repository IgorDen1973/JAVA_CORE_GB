package ru.geekbrains.JAVA2.lesson7even.project.controller;

import ru.geekbrains.JAVA2.lesson7even.project.AppGlobalState;
import ru.geekbrains.JAVA2.lesson7even.project.model.*;
import ru.geekbrains.JAVA2.lesson7even.project.model.entity.Weather;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class Controller implements IController{

    ICityCodeProvider codeProvider = new AccuWeatherCityCodeProvider(); // ищет код города
    IWeatherProvider weatherProvider = new AccuWeatherProvider(); // ищет погоду по коду города
    IWeatherRepository weatherRepository = new SQLiteWeatherRepository(); // архивная БД погоды


    @Override
    public void onCityInput(String city) throws IOException {

      if(city.length() == 1) {
          throw new  IOException("Недопустимо короткое название города");
      }
          codeProvider.getCodeByCityName(city);   // вызываем у объекта AccuWeatherCityCodeProvider метод поиска кода

    }

    @Override
    public void onCommandChosen(int selectedCommand) throws IOException, ParseException {
        System.out.println(" ");
        switch (selectedCommand) {
            case 1: {
                Weather currentWeather = weatherProvider.getCurrentWeather(AppGlobalState.getInstance().getCityKey()); // на 1 день
                System.out.println(currentWeather);
                weatherRepository.saveWeatherObject(currentWeather);
                break;
            }
            case 2: {   // *********************** добавил  *****************
                weatherProvider.getWeatherForFiveDays(AppGlobalState.getInstance().getCityKey());// на 5 дней
                break;
            }
            case 3: {   // =================================================================
                List<Weather> allData = weatherRepository.getAllData();// вывод архива
                allData.forEach(System.out::println);

                break;
            }
            default: {
                throw new IOException("Неверный ввод\n");
            }
        }
    }

}
