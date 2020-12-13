package ru.geekbrains.JAVA2.lesson2;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String message) {
        super("Тип данных запрещен для данного массива "+message);
    }
}
     // для исключений (как для объектов), создаем свои классы, дочерние от суперкласса RuntimeException