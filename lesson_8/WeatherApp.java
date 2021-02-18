package ru.geekbrains.JAVA2.lesson_7;

import com.fasterxml.jackson.databind.*;
import com.ibm.icu.text.Transliterator;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class WeatherApp {

    public static void main(String[] args) throws IOException, ParseException, SQLException {

                      //  ФОРМИРУЕМ ЗАПРОС НА СЕРВЕР И ЗАПИСЫВАЕМ ОТВЕТ В ФАЙЛ
//
//        OkHttpClient client = new OkHttpClient()
//                .newBuilder()
//                .connectTimeout(10, TimeUnit.DAYS.SECONDS)
//                .readTimeout(10, TimeUnit.SECONDS)
//                .writeTimeout(10, TimeUnit.SECONDS)
//                .followRedirects(true)
//                .retryOnConnectionFailure(true)
//                .build();
//
//
//
//        Request request = new Request.Builder()
//                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=8yTRkRFeG2T8RIydXHoTB7pu2cH779hw&language=ru&metric=true")
//                .method("GET", null)
//                .addHeader("Content-Type", "application/json")
//                .addHeader("Accept-Language", "ru-RU")
//                .build();
//
//        Response response = client.newCall(request).execute();
//
//        File fileX = new File("test1.json");
//        try (OutputStream output7 = new FileOutputStream(fileX)) {
//            output7.write(response.body().string().getBytes(StandardCharsets.UTF_8));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
                           // НЕПОСРЕДСТВЕННО ДОМАШНЕЕ ЗАДАНИЕ К УРОКУ # 7

        ObjectMapper objectMapper = new ObjectMapper();  // создали объект класса ObjectMapper

//        System.out.println(" ------------------------------------------------------- ");
//        System.out.println("           ПОГОДА НА СЛЕДУЮЩИЕ 5 ДНЕЙ:");
//        System.out.println(" ------------------------------------------------------- ");
        // ПИШЕМ КЛАССЫ , ПРЕДВАРИТЕЛЬНО АНАЛИЗУРУЯ СТРОКУ ОТВЕТА СЕРВЕРА, УСЛОВИЯ ДЕСЕРИАЛИЗАЦИИ = ПУСТОЙ КОНСТРУКТОР И СЕТТЕРЫ
                      // СОЗДАЕМ ОБЪЕКТ ИЗ JSON-ФАЙЛА   * ДЕСЕРИАЛИЗАЦИЯ *
        WeatherResponse serverResponse = objectMapper.readValue(new File("test1.json"), WeatherResponse.class);

//        try {
                                   // Java объект в JSON файл
//            objectMapper.writeValue(new File("weather_accu2.json"), serverResponse);
                           // Java объект в JSON строку * СЕРИАЛИЗАЦИЯ ДЛЯ ПРОВЕРКИ *
//            String jsonString = objectMapper.writeValueAsString(serverResponse);
//            System.out.println(jsonString);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
                           // упоминание о городе запроса находим только в ссылке
          String [] linkWithCity = serverResponse.getHeadline().getLink().split("/");
          String piter = linkWithCity[5];

//        try {
            // Перевод латинских букв в кириллицу (название города только в линке на английском)
            var CYRILLIC_TO_LATIN = "Latin-Russian/BGN";
            Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
            String result = toLatinTrans.transliterate(piter);
            String res = toUpperFirst(result);


                        // создаем привычный формат для даты
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMMM yyyy года");
            WeatherApp weatherApp = new WeatherApp();
            for (int i = 0; i < serverResponse.getDailyForecasts().length; i++) {
                Date date = new SimpleDateFormat("y-M-d").parse((serverResponse.getDailyForecasts()[i].getDate()).substring(0, 10));

//                System.out.println("В городе " + res + " на дату " + dateFormat.format(date));
//                System.out.printf("ожидается днем: " + (serverResponse.getDailyForecasts()[i].getDay().getIconPhrase()).toLowerCase());
//                System.out.println(", ночью: " + (serverResponse.getDailyForecasts()[i].getNight().getIconPhrase()).toLowerCase() + " ");
//                System.out.printf("температура в диапазоне от " + (serverResponse.getDailyForecasts()[i].getTemperature().getMinimum().getValue()));
//                System.out.println("\u00b0C" + " до " + (serverResponse.getDailyForecasts()[i].getTemperature().getMaximum().getValue()) + "\u00b0C.");
//                System.out.println("........................................................");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

                //  HOME  WORK # 8 ..........................................................

                String localDate = dateFormat.format(date);
                Double temp1 =  // делаю среднюю между максимальной и минимальной
                        ((serverResponse.getDailyForecasts()[i].getTemperature().getMinimum().getValue())+
                                (serverResponse.getDailyForecasts()[i].getTemperature().getMaximum().getValue()))/2;
                Double temperature = Double.valueOf(Math.round( temp1*100)/100);
                String weatherText = (serverResponse.getDailyForecasts()[i].getDay().getIconPhrase()).toLowerCase();

                // ЗАКОММЕНТИРОВАЛ ЧТОБЫ НЕ РУГАЛАСЬ, ТАК КАК УЖЕ С ПЕРВОГО ЗАХОДА ЗАПИСАЛА ДАННЫЕ!!!
                if (weatherApp.open()) {
//              weatherApp.insert(localDate,res,temperature,weatherText);
                }

            }
        System.out.println(" ");
            weatherApp.selectAll();
        System.out.println(" ");
            weatherApp.select();
            weatherApp.close();

        // .................................................................................

    }


    Connection connection;
    boolean open () {
        try {
            Class.forName("org.sqlite.JDBC"); // инициализация драйвера, org.sqlite.JDBC - имя движка
            connection = DriverManager.getConnection("jdbc:sqlite:c:\\sqlite\\weather.db"); // установим коннекшн, подключим драйверменеджер ,
                                                // и вызываем подключение (гет канекшн), протокол:база:файл
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    void insert(String localDate,String city,Double temperature, String weatherText) throws SQLException {
            String query = "INSERT INTO weather (localDate, city, temperature, weatherText) \n" +
                    "VALUES ('" + localDate + "','" + city + "','" + temperature + "','" + weatherText + "' );";        // создаем запрос query
            Statement statement = connection.createStatement();       // создаем объект Statement (создаем запрос)
            statement.executeUpdate(query); // запрос на апдейт, т.е. обновление данных

            statement.close(); // закрываем подключение
    }

    void selectAll() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT localDate, city, temperature, weatherText "+
                    "FROM weather ORDER BY localDate";
            ResultSet resultSet = statement.executeQuery(query);     // класс Resultset - множество результатов
            // executeQuery - выполнить запрос
            while (resultSet.next()){
                String localDate = resultSet.getString("localDate");
                String city = resultSet.getString("city");
                Double temperature = resultSet.getDouble("temperature");
                String weatherText = resultSet.getString("weatherText");

                System.out.println(localDate+ "\t " +city+ "\t "+temperature+"\t " +weatherText);
            }
            resultSet.close();
            statement.close();

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void select() {
        try {
            Statement statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите пожалуйста дату прогноза:  ");
            String localDate2 = scanner.nextLine();

            String query = "SELECT localDate, city, temperature, weatherText "+
                    "FROM weather WHERE localDate = "+"'"+localDate2+"'";
            ResultSet resultSet = statement.executeQuery(query);     // класс Resultset - множество результатов
            // executeQuery - выполнить запрос
            while (resultSet.next()){
                String localDate = resultSet.getString("localDate");
                String city = resultSet.getString("city");
                Double temperature = resultSet.getDouble("temperature");
                String weatherText = resultSet.getString("weatherText");

                System.out.println(localDate+ "\t " +city+ "\t "+temperature+"\t " +weatherText);
            }
            resultSet.close();
            statement.close();
            scanner.close();

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void close() {
        try {
            connection.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static String toUpperFirst(String str) {  // метод "корректировки" названия города с тире " - "

        StringBuilder builder = new StringBuilder(str.length());
        builder.append(Character.toUpperCase(str.charAt(0)));
        for (int i = 1; i < (str.length()); i++) {
            char c = str.charAt(i);
            if (c == '-') {
                builder.append(c);
                builder.append(Character.toUpperCase(str.charAt(i+1)));
                i++;
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }


}
