package ru.geekbrains.JAVA2.lesson2;

public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException() {
        super("Массив не размера 4*4!");
    }
}

      // для исключений (как для объектов), создаем свои классы, дочерние от суперкласса RuntimeException