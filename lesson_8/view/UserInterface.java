package ru.geekbrains.JAVA2.lesson7even.project.view;

import ru.geekbrains.JAVA2.lesson7even.project.controller.Controller;
import ru.geekbrains.JAVA2.lesson7even.project.controller.IController;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class UserInterface implements IUserInterface{

    IController controller = new Controller(); // для связи между контроллером и вью создадим объект серез интерфейс, чьобы потом можно было подменить реализацию

    @Override
    public void showMenu() {  // показывает меню в бесконечном цикле
        while (true) {
            System.out.println(" ");
//            System.out.println("Введите название города на английском языке или 'exit' для выхода");
            System.out.println("Какую информацию Вы хотите получить?"); //  *********************************
            System.out.println("\n1 - получение сведений о погоде в определенном городе\n2 - получение архивных данных предыдущих запросов\n \nвведите 'exit' для выхода");

            Scanner scanner = new Scanner(System.in);

            String menuChoice = scanner.nextLine();

            checkIsExit(menuChoice); // проверка на выход


            if (menuChoice.equalsIgnoreCase("2")) { // если "2" - идем получать архив
                try {
                    controller.onCommandChosen(3);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Введите название города на латинице:");
                String userResponse = scanner.nextLine();

                try { // на случай отсутствия такого города на сервере
                    controller.onCityInput(userResponse);
                } catch (Exception e) {
                    e.printStackTrace(); // в случае ошибки опять переходи к началу (запросу города)
                    continue;
                }
                // УБИРАЕМ ИЗ ДИАЛОГОВОГО МЕНЮ ВЫБОР АРХИВНЫХ ДАННЫХ ******************************
//            System.out.println("Введите команду\n1 - для получения погоды на текущий день\n2 - для получения погоды на 5 дней\n3 - для вывода архивной информации");
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
    }

    private void checkIsExit(String userResponse) {    // проверка на желание выйти
        if (userResponse.equalsIgnoreCase("exit") ||
                userResponse.equalsIgnoreCase("выход")) {

            System.out.println("Завершаю работу....");
            System.exit(0);
        }
    }
}
