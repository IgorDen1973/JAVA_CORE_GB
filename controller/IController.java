package ru.geekbrains.JAVA2.lesson7even.project.controller;

import java.io.IOException;
import java.text.ParseException;

public interface IController {

    void onCityInput (String city) throws IOException;

    void onCommandChosen(int selectedCommand) throws IOException, ParseException;
}
