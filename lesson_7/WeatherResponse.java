package ru.geekbrains.JAVA2.lesson_7;

import com.fasterxml.jackson.annotation.JsonProperty;


public class WeatherResponse {
    private Headline headline;
    private DailyForecast[] dailyForecasts;


    public WeatherResponse() {
    }

    @JsonProperty("Headline")
    public Headline getHeadline() {
        return headline; }

        @JsonProperty("Headline")
    public void setHeadline(Headline value) {
        this.headline = value; }


        @JsonProperty("DailyForecasts")
    public DailyForecast[] getDailyForecasts() {
        return dailyForecasts; }

        @JsonProperty("DailyForecasts")
    public void setDailyForecasts(DailyForecast[] value) {
        this.dailyForecasts = value; }



}
