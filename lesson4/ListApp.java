package ru.geekbrains.JAVA2.lesson4;


import java.util.*;

public class ListApp {


    public static void main(String[] args) {
        System.out.println(" ");

        List<String> list11 = new ArrayList<>(Arrays.asList("Owl", "Sailor", "Dork", "Owl"));
        list11.add("Ray");
        list11.add("Ray");
        list11.add("Dinner");
        list11.add("Ray");
        list11.add("Sunlight");
        list11.add("Dinner");
        list11.add("Cat");
        System.out.println(list11);
        System.out.println(" ");

        Set<String> set11 = new HashSet<String>(list11); // Класс HashSet служит для создания
        System.out.println(set11);                 //коллекции, содержащей только уникальные элементы
        System.out.println(" ");

//        Метод java.util.Collections.frequency () присутствует в классе java.util.Collections.
//        Он используется для получения частоты присутствия элемента в указанном списке коллекции.

        for (String listItem : set11) {
            System.out.printf(listItem + "-> " + Collections.frequency(list11, listItem)+" times;  ");
        }
        System.out.println(" ");


        // ТЕЛЕФОННАЯ КНИГА

        System.out.println(" ");

        YellowPages book = new YellowPages();

        book.addRecord("Smith", "8-001-34878"); // добавляем абонентов
        book.addRecord("Samuelson", "8-001-67890");  // методом addRecord
        book.addRecord("Davidoff", "8-001-87345");
        book.addRecord("Li", "8-001-09756");
        book.addRecord("Smith", "8-001-99087");
        System.out.println(" ");

        System.out.println("Method getRecord : ");
        System.out.println("Davidoff: "+book.getRecord("Davidoff"));
        System.out.println("Smith: "+book.getRecord("Smith"));
        System.out.println(" ");

        System.out.println("Same number for existing KEY: ");
        book.addRecord("Smith", "8-001-99087");
        System.out.println("Smith: "+book.getRecord("Smith"));
        System.out.println(" ");

        System.out.println("Wrong search : ");
        System.out.println("Lavroff");
        System.out.println(book.getRecord("Lavroff"));
        System.out.println(" ");
    }
}












