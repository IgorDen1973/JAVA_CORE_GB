package ru.geekbrains.JAVA2.lesson1;

import java.util.Random;
import java.util.Scanner;

public class MainLesson1 {

    public static void main(String[] args) {

        String[] Items = {"Cat", "Man", "Robot"};

        String[] names = new String[3];   // в массиве names - имена (для дальнейшей инициализации объектов Athletic)
        System.out.println();
        int v = 0;
        for (String k : names) {
            System.out.println("Please write a name for the " + Items[v] + ":");
            Scanner scan = new Scanner(System.in);
            String a = scan.nextLine();
            names[v] = a;
            v++;
        }

        int[] distanceMax = new int[3]; // в массиве distanceMax - макимальная длина пробежки (для дальнейшей инициализации)
        System.out.println();
        System.out.println("* Enter data in the range from 3000 to 10000 meters *");
        int x = 0;
        for (String m : Items) {
            System.out.println("How long can " + m + " run ? :");
            Scanner scan = new Scanner(System.in);
            int a = scan.nextInt();
            int f = rangeCheck(a, 3000, 10000); // задаем адекватный диапазон для пробежки
            distanceMax[x] = f;
            x++;

        }
        double[] Max_height = new double[3];
        System.out.println();     // в массиве Max_height - макимальная длина пробежки (для дальнейшей инициализации)
        System.out.println("* Enter data in the range from 0,5 to 1,9 meters *");
        System.out.println("* please use comma (,) don't use dot (.) *");
        System.out.println();

        int y = 0;
        for (String n : Items) {
            System.out.println("How high can " + n + " jump ? :");
            Scanner scan = new Scanner(System.in);
            double j = scan.nextDouble();
            double f = rangeCheck2(j, 0.5, 1.9); // задаем адекватный диапазон для высоты прыжка
            Max_height[y] = f;
            y++;
            if (y == Items.length) {
                scan.close();
            }
        }

        System.out.println();

        Athletic[] dudes = new Athletic[3];   // создаем объекты , проявление ПОЛИМОРФИЗМА
        dudes[0] = new Cat(names[0], distanceMax[0], Max_height[0]);  // один тип - Athletic
        dudes[1] = new Man(names[1], distanceMax[1], Max_height[1]);
        dudes[2] = new Robot(names[2], distanceMax[2], Max_height[2]);
        System.out.println();
        System.out.println("Dudes gonna overcome next obstacles:");
        System.out.println();

        Obstacle[] tasks = new Obstacle[5]; // опять ПОЛИМОРФИЗМ - препятствия (забор, дорожка) от одного "родителя"
                                            // создадим 5 случайных препятствий
        Random rand = new Random();
        boolean whichObstacle;           // переменная которая будет генериться случайно, в зависимости от ее значения
        whichObstacle = rand.nextBoolean();        // следующим препятствием будет либо забор, либо дорожка
        int[] taskIndex = new int[5];
        for (int i = 0; i < tasks.length; i++) {
            whichObstacle = rand.nextBoolean();
            if (whichObstacle) {
                int min = 1000;              // если whichObstacle true - генерим дорожку
                int max = 15000;
                int diff = max - min;
                Random random = new Random();
                int z = random.nextInt(diff + 1);
                z += min;
                tasks[i] = new Track(z);
                taskIndex[i] = 1;        // "трюк" - создаем массив, в котором "1" - создалось препятствие дорожка
                System.out.println(+i + 1 + ". Track long as " + z + " meters.");
            } else {                       // если whichObstacle false - генерим забор
                double random = Math.random() + 1;
                double roundOff = Math.round(random * 100.0) / 100.0;
                tasks[i] = new Fence(roundOff);
                taskIndex[i] = 0;  // записываем "0" в массив taskIndex - создалось препятствие забор
                System.out.println(+i + 1 + ". Fense high as " + roundOff + " meters.");
            }
        }
        System.out.println(" ");

        for (int p = 0; p < dudes.length; p++) {
            int i = 0;
            for (int q = 0; q < taskIndex.length; q++) {
                boolean upshot = true;
                if (upshot = true) {
                    System.out.printf(+q + 1 + ". ");
                    if (taskIndex[q] == 1) {  //  используем "трюк", если в массиве 1 - дорожка
                        upshot = dudes[p].run(tasks[i].getLength());  // тут видим результат в boolean
                    } else upshot = dudes[p].jump(tasks[i].getHeight());  // тут видим результат в boolean
                    i++;
                }
                if (!upshot) {
                    break;
                }
            }
            System.out.println(" ");
        }

    }

    private static int rangeCheck(int a, int min, int max) {  // метод проверки адекватности ввода длины пробежки
        if (a > min && a < max) {
        } else do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Data entered out of range");
            System.out.println("try one more time:");
            a = scan.nextInt();
        } while (a < min || a > max);
        return a;
    }

    private static double rangeCheck2(double j, double min, double max) {
        if (j > min && j < max) {                                        // адекватность введенной высоты прыжка
        } else do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Data entered out of range");
            System.out.println("try one more time:");
            j = scan.nextDouble();
        } while (j < min || j > max);
        return j;
    }
}

