package ru.geekbrains.JAVA2.lesson7even.project.model;

import java.io.IOException;

public interface ICityCodeProvider {
    void getCodeByCityName(String cityName) throws IOException;
}
