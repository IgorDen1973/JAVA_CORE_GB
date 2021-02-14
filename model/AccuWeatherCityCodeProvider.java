package ru.geekbrains.JAVA2.lesson7even.project.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.geekbrains.JAVA2.lesson7even.project.AppGlobalState;

import java.io.IOException;

public class AccuWeatherCityCodeProvider implements ICityCodeProvider {
// этот класс будет входить в сеть, значит ему нужен http-client, API key

    private static final String BASE_HOST = "dataservice.accuweather.com"; // хост куда мы "стучимся" , базовый хост
    private static final String LOCATIONS_SERVICE_PATH = "locations"; //
    private static final String API_VERSION = "v1";
    private static final String API_KEY = AppGlobalState.getInstance().getApiKey();


    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper(); // потому что ответ в "JSON"

    @Override
    public void getCodeByCityName(String cityName) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete?apikey={{accuweatherApiKey}}&q=Brest

        // СОБИРАЕМ URL:
        HttpUrl detectLocationUrl = new HttpUrl.Builder()  // билдер URL
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS_SERVICE_PATH)
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete") // после "?" идут QueryParameter
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", cityName)
                .build();

        // СОБИРАЕМ REQUESt :
        Request detectLocationRequest = new Request.Builder()  // билдер
                .addHeader("accept", "application/json") // ХЭДЕР , говорящий что будем работать с "JSON"
                .url(detectLocationUrl)
                .build();

        // Исполняем запрос:

        Response response = client.newCall(detectLocationRequest).execute(); // создаем объект ответа
        // в ответе нам присылается варианты городов с искомым названием, причем города в массиве, берем первый город
        if (!response.isSuccessful()) {
            throw new IOException("Сетевая ошибка\n");
        }

        String jsonBody = response.body().string();

        if (objectMapper.readTree(jsonBody).size() < 1) { // если в массиве 0 элементов, то город не нашелся
            throw new IOException("Города с таким названием не нашлось\n"); // readTree - читаем дерево JSONa ответа Маппером
        }

        String cityTitle = objectMapper.readTree(jsonBody).get(0).at("/LocalizedName").asText(); // берем первый элемент массива -имя
        String countryTitle = objectMapper.readTree(jsonBody).get(0).at("/Country/LocalizedName").asText();// берем первый элемент массива -страна

        String cityKey = objectMapper.readTree(jsonBody).get(0).at("/Key").asText(); //вытаскиваем ключ города
        System.out.println(" ");

        System.out.printf("Найден город %s в стране %s!\n", cityTitle, countryTitle);
        System.out.println(" ");
        AppGlobalState.getInstance().setCityName1(cityTitle);// *********** пишем название города  **************************


        AppGlobalState.getInstance().setCityKey(cityKey); // записываем ключ города

    }


}
