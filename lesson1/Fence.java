package ru.geekbrains.JAVA2.lesson1;

public class Fence extends Obstacle {

    private double heigth;

    public Fence(double input) {  // в конструктор только высоту запихиваем при создании
        this.heigth = input;
    }
    @Override
    int getLength() {  // не задействован, но объявлен в супер-классе , потому "обнулил"
        return 0;
    }
    @Override
    double getHeight() {
        return this.heigth;
    }
}
