package ru.geekbrains.JAVA2.outStanding.view;


import ru.geekbrains.JAVA2.outStanding.controller.Controller;
import ru.geekbrains.JAVA2.outStanding.controller.IController;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class UserInterface implements IUserInterface{

    IController controller = new Controller(); // для связи между контроллером и вью создадим объект серез интерфейс, чьобы потом можно было подменить реализацию

    @Override
    public void showMenu() {  // показывает меню в бесконечном цикле
        while (true){
            System.out.println(" ");
            System.out.println("Введите название города на английском языке или 'exit' для выхода");
            Scanner scanner = new Scanner(System.in);

            String userResponse = scanner.nextLine();

            checkIsExit(userResponse);

            try { // на случай отсутствия такого города на сервере
                controller.onCityInput(userResponse);
            } catch (Exception e) {
                e.printStackTrace(); // в случае ошибки опять переходи к началу (запросу города)
                continue;
            }

            System.out.println("Введите команду\n1 - для получения погоды на текущий день\n2 - для получения погоды на 5 дней");

            System.out.println(" ");
            int selectedCommand = scanner.nextInt();

            try {
                controller.onCommandChosen(selectedCommand); // передаем сигнал контроллеру , команду
            } catch (IOException | ParseException e) {
                e.printStackTrace();
                continue;
            }

        }

    }

    private void checkIsExit(String userResponse) {    // проверка на желание выйти
        if (userResponse.equalsIgnoreCase("exit") ||
                userResponse.equalsIgnoreCase("выход")) {

            System.out.println("Завершаю работу....");
            System.exit(0);
        }
    }
}
