package ru.geekbrains.JAVA2.lesson7even.project;

import ru.geekbrains.JAVA2.lesson7even.project.model.entity.Weather;

import java.sql.*;

public class AppGlobalState {  // класс для хранения информации
    // Singleton относится к пораждающим паттернам. Его дословный перевод – одиночка.
    // Этот паттерн гарантирует, что у класса есть только один объект

    // ИНИЦИАЛИЗИРУЕМ БАЗУ ДАННЫХ:     //===================================================
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection connection;

    private static Statement statement;

    private static PreparedStatement insertWeatherPreparedStatement;

    private static AppGlobalState instance; // экземпляр класса

    public String cityName1;    //************  добавил название города    **********

    private String cityKey;

    public String getCityName1() {   //**********************************************

        return cityName1;
    }

    public static Connection getConnection() {

        return connection;
    }

    public static Statement getStatement(){
        return statement;
    }

    public static PreparedStatement getInsertWeatherPreparedStatement() {

        return insertWeatherPreparedStatement;
    }

    public void setCityName1(String cityName1) {     //**********************************************

        this.cityName1 = cityName1;
    }

    public String getCityKey() {

        return cityKey;
    }

    public void setCityKey(String cityKey) {

        this.cityKey = cityKey;
    }

    public String getDbName() {

        return "weather-app.db";
    }


    private AppGlobalState() {  //приватный конструктор, объект класса нельзя создать кроме, как из самого класса
        try {  //  !!!!!!!!  ПРАВИЛЬНО УКАЗАТЬ ПУТЬ К БАЗЕ ДАННЫХ !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            connection = DriverManager.getConnection("jdbc:sqlite:c:\\sqlite\\"+getDbName());
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS weather(" +
            "date TEXT NOT NULL,city TEXT NOT NULL, temp TEXT NOT NULL, text TEXT NOT NULL);");
            insertWeatherPreparedStatement = connection.prepareStatement(
                    "INSERT INTO weather (date, city, temp, text) VALUES (?,?,?,?);"
            );

            // *********

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.exit(1); // выход с ошибкой
        }
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
