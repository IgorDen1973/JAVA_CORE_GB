package ru.geekbrains.JAVA2.lesson7even.project;

public class AppGlobalState {  // класс для хранения информации
    // Singleton относится к пораждающим паттернам. Его дословный перевод – одиночка.
    // Этот паттерн гарантирует, что у класса есть только один объект

    private static AppGlobalState instance; // экземпляр класса

    public String cityName1;    //************  добавил название города    **********

    private String cityKey;

    public String getCityName1() {   //**********************************************

        return cityName1;
    }

    public void setCityName1(String cityName1) {

        this.cityName1 = cityName1;
    }

    public String getCityKey() {

        return cityKey;
    }

    public void setCityKey(String cityKey) {

        this.cityKey = cityKey;
    }

    private AppGlobalState() {  //приватный конструктор, объект класса нельзя создать кроме, как из самого класса
    }
    public static AppGlobalState getInstance () {
        if (instance == null) {
            instance = new AppGlobalState();
        }
        return instance;
    }


    public String getApiKey() {

        return "8yTRkRFeG2T8RIydXHoTB7pu2cH779hw";
    }
}
