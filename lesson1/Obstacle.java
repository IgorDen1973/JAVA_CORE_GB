package ru.geekbrains.JAVA2.lesson1;

    abstract class Obstacle {

        abstract int getLength();    // поставил только два геттера на получение случайно сгенерированной
        abstract double getHeight();  // высоты или длины, при чем для достоверности высоту сделал double
    }                                 // чтобы не было тупо int = 1,2,3 ... хотя помучался с округлением
                                      // double после генерации random :-)
