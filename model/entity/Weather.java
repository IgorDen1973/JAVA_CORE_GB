package ru.geekbrains.JAVA2.outStanding.model.entity;

public class Weather {

    private String date;
    private String city;
    private String temperature;
    private String weatherText;

    public Weather(String date, String city, String temperature, String weatherText) {
        this.date = date;
        this.city = city;
        this.temperature = temperature;
        this.weatherText = weatherText;
    }

    public Weather() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    @Override
    public String toString() {
        return "\nAt "+ date + " in " + city + " expected " + weatherText + " with temperature " +temperature+"C";
    }


}
