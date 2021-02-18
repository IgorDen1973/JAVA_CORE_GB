package ru.geekbrains.JAVA2.lesson7even.project.controller;

import ru.geekbrains.JAVA2.lesson7even.project.AppGlobalState;
import ru.geekbrains.JAVA2.lesson7even.project.model.AccuWeatherCityCodeProvider;
import ru.geekbrains.JAVA2.lesson7even.project.model.AccuWeatherProvider;
import ru.geekbrains.JAVA2.lesson7even.project.model.ICityCodeProvider;
import ru.geekbrains.JAVA2.lesson7even.project.model.IWeatherProvider;

import java.io.IOException;
import java.text.ParseException;

public class Controller implements IController{

    ICityCodeProvider codeProvider = new AccuWeatherCityCodeProvider(); // ищет код города
    IWeatherProvider weatherProvider = new AccuWeatherProvider(); // ищет погоду по коду города


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
                weatherProvider.getCurrentWeather(AppGlobalState.getInstance().getCityKey()); // на 1 день
                break;
            }
            case 2: {   // *********************** добавил  *****************
                weatherProvider.getWeatherForFiveDays(AppGlobalState.getInstance().getCityKey());// на 5 дней
                break;
            }

            default: {
                throw new IOException("Неверный ввод\n");
            }
        }
    }

}
