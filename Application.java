package ru.geekbrains.JAVA2.outStanding;


import ru.geekbrains.JAVA2.outStanding.view.IUserInterface;
import ru.geekbrains.JAVA2.outStanding.view.UserInterface;

public class Application {
    public static void main(String[] args) {

        IUserInterface ui = new UserInterface();

        ui.showMenu();


    }
}
