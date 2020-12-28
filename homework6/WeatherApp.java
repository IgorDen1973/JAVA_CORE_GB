package ru.geekbrains.homework6;

import okhttp3.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;


public class WeatherApp {


    public static void main(String[] args) throws IOException, ParseException {

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();

        System.out.println("______________________________________");
        System.out.println(" ");


        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=8yTRkRFeG2T8RIydXHoTB7pu2cH779hw&language=ru&metric=true")
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept-Language", "ru-RU")
                .build();

        Response response = client.newCall(request).execute();

        File fileX = new File("weather.json");
        try (OutputStream output7 = new FileOutputStream(fileX)) {
            output7.write(response.body().string().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            // считывание файла JSON
            FileReader reader = new FileReader("weather.json");

            JSONParser jsonParser = new JSONParser();  //После создания экземпляра JSONParser
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);   //мы создаем объект JSONObject


            // получение массива
            JSONArray forecastsArr = (JSONArray) jsonObject.get("DailyForecasts");

            Iterator i = forecastsArr.iterator();

            System.out.println(" ");
            // берем каждое значение из массива json отдельно
            while (i.hasNext()) {
                JSONObject innerObj = (JSONObject) i.next();
                String x = (String) innerObj.get("Date");
                System.out.println("Дата: " + x.substring(0, 10) + " ");


                JSONObject temperature = (JSONObject) innerObj.get("Temperature");
                JSONObject minInside = (JSONObject) temperature.get("Minimum");
                JSONObject maxInside = (JSONObject) temperature.get("Maximum");
                JSONObject day = (JSONObject) innerObj.get("Day");
                JSONObject night = (JSONObject) innerObj.get("Night");
                System.out.printf("Минимальная температура: " + minInside.get("Value") + "\u00b0 ");
                System.out.println("Максимальная температура: " + maxInside.get("Value") + "\u00b0 ");
                System.out.printf("Днем: " + day.get("IconPhrase") + "; ");
                System.out.println(" Ночью: " + night.get("IconPhrase"));
                System.out.println(" ");

            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}












