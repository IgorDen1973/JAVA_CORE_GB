package ru.geekbrains.JAVA2.lesson1;

public class Track extends Obstacle {

    private int length;

    public Track(int input) {    // в конструктор только длину запихиваем при создании
        this.length = input;
    }
    @Override
    int getLength() {
        return this.length;
    }
    @Override
    double getHeight() {      // не задействован, но объявлен в супер-классе , потому "обнулил"
        return 0.0;
    }
}