package ru.geekbrains.JAVA2.outStanding.model;

import java.io.IOException;

public interface ICityCodeProvider {
    void getCodeByCityName(String cityName) throws IOException;
}
