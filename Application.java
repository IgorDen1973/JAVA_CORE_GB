package ru.geekbrains.JAVA2.lesson7even.project;

import ru.geekbrains.JAVA2.lesson7even.project.view.IUserInterface;
import ru.geekbrains.JAVA2.lesson7even.project.view.UserInterface;

public class Application {
    public static void main(String[] args) {

        IUserInterface ui = new UserInterface();

        ui.showMenu();


    }
}
