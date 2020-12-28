package ru.geekbrains.JAVA2.lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class YellowPages {   //   используем класс HashMap <K,V>

    // "...искать номер телефона по фамилии." значит ключ K  - Фамилия
    // "..под одной фамилией может быть несколько телефонов.." V  - для создания списков интерфейс List

//    public YellowPages() {
//    }
private HashMap <String, List<String>>  record = new HashMap<>(); // Создаем пустой HashMap




    void addRecord(String secondName, String telNumber){
        boolean x = record.containsKey(secondName); //проверка есть ли уже в HashMap ключ (Фамилия)
        if(x){         //  если есть, то либо добавляем, либо проверяем на дублирование
            List<String> telNumbers = record.get(secondName);  // создаем список для Ключа (Фамилии)
            if(!telNumbers.contains(telNumber)){      // из уже имеющихся у него номеров
                telNumbers.add(telNumber); // add-ом добавляем номер
                System.out.println("Additional number: "+telNumber+"  for  "+secondName);
            } else {
                System.out.println("Number : "+telNumber+" for "+secondName+" has already exist!");
            }
        }
        if (!x){  // если Фамилии (ключа) нет, это новый абонент, просто вносим запись put -ом
            record.put(secondName, new ArrayList<>(Arrays.asList(telNumber)));
            System.out.println("Created new one : "+secondName+"   with number: "+telNumber);
        }
    }


    List<String> getRecord(String secondName){  // создадим метод для интерфейса List
        if(record.containsKey(secondName)){ // на вход кидаем ключ-Фамилию
            return record.get(secondName);  // возвращает нам "значение" т.е. телефонный номер
        } else {
            System.out.println("No record detected! ");
            Object a = "Nothing";
            List listNull = new ArrayList();  // возвращаем пустые значения
            listNull.add(a);
            return listNull;
        }
    }
}
