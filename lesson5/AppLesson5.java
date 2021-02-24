package ru.geekbrains.JAVA2.lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AppLesson5 {

    public static void main(String[] args) {


        File fileWithData = new File("home_work.csv");

        try (BufferedWriter writerIn = new BufferedWriter(new FileWriter("home_work.csv"))) {
            writerIn.write("Column #1;Column #2;Column #3;Column #4\n");
            writerIn.write("100;200;999;809\n");
            writerIn.write("300;400;500;999\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<AppData> head = new ArrayList<>(); //создадим список объектов класса AppData

        try (BufferedReader readIn = new BufferedReader(new FileReader("home_work.csv"))) {
            String[] headers = (readIn.readLine()).split("\\;"); // создадим String массив из заголовков
            String[] data1 = (readIn.readLine()).split("\\;");  // создадим String массив для второй строки
            int dataInt1[] = new int[data1.length];
            for (int i = 0; i < data1.length; i++) {   // поменяем тип данных и массива на int
                dataInt1[i] = Integer.parseInt(data1[i]);
            }
            String[] data2 = (readIn.readLine()).split("\\;");
            int dataInt2[] = new int[data2.length]; // создадим String массив для третьей строки
            for (int i = 0; i < data2.length; i++) {  // так как строки всего две - не создавал цикл, кода меньше не будет
                dataInt2[i] = Integer.parseInt(data2[i]); // поменяем тип данных и массива на int
            }
            int dataFinal[][] =  {dataInt1,dataInt2}; // запихнем в двухмерный массив, как по заданию, на вход AppData

            System.out.println(" ");

            AppData newOne = new AppData(headers,dataFinal); // создадим объект
            head.add(newOne);  // добавим его в список

            for (AppData u : head) {
                System.out.println(u);
            }
        } catch (IOException e) {  // эксепшаны как положено на случай ошибок (отсутствия файла по адресу и т.п.)
            e.printStackTrace();
        }
        System.out.println(" ");

    }
}

