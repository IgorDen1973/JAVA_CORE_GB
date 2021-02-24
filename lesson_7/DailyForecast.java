package ru.geekbrains.JAVA2.lesson_7;

import com.fasterxml.jackson.annotation.JsonProperty;


public class DailyForecast {
    private String date;
    private long epochDate;
    private Temperature temperature;
    private Day day;
    private Night night;
    private String[] sources;
    private String mobileLink;
    private String link;

    public DailyForecast() {
    }

    @JsonProperty("Date")
    public String getDate() { return date; }
    @JsonProperty("Date")
    public void setDate(String value) { this.date = value; }

    @JsonProperty("EpochDate")
    public long getEpochDate() { return epochDate; }
    @JsonProperty("EpochDate")
    public void setEpochDate(long value) { this.epochDate = value; }


        @JsonProperty("Temperature")
    public Temperature getTemperature() {
        return temperature; }

        @JsonProperty("Temperature")
    public void setTemperature(Temperature value) { this.temperature = value; }

    @JsonProperty("Day")
    public Day getDay() { return day; }
    @JsonProperty("Day")
    public void setDay(Day value) { this.day = value; }

    @JsonProperty("Night")
    public Night getNight() { return night; }
    @JsonProperty("Night")
    public void setNight(Night value) { this.night = value; }

    @JsonProperty("Sources")
    public String[] getSources() { return sources; }
    @JsonProperty("Sources")
    public void setSources(String[] value) { this.sources = value; }

    @JsonProperty("MobileLink")
    public String getMobileLink() { return mobileLink; }
    @JsonProperty("MobileLink")
    public void setMobileLink(String value) { this.mobileLink = value; }

    @JsonProperty("Link")
    public String getLink() { return link; }
    @JsonProperty("Link")
    public void setLink(String value) { this.link = value; }






}
