package ru.geekbrains.JAVA2.lesson2;


public class MainClass {
    public static void main(String[] args) {


        String[][] arr1 = {{"5", "5", "5", "5"},
                           {"5", "5", "5", "5"}};

        String[][] arr2 = {{"5", "5", "5", "5"},
                           {"5", "5", "5", "5"}};

        String[][] arr3 = {{"5", "5", "5", "5",},
                           {"5", "5", "*", "5"}};

        System.out.println(" ");

        String[][][] arrB = {arr1,arr2,arr3};  // загнал в "проверочный" массив чтобы уменьшить код одинаковый

        int sumResult = 0;
        for(int i = 0; i < arrB.length;i++) {
            try {
                sumResult = 0;
                sumResult = checkArray(arrB[i]);
            } catch (MyArraySizeException e) {
                System.out.println(e.getMessage());
            } catch (MyArrayDataException e) {
                System.out.println(e.getMessage());
            }
                System.out.println("Сумма всех элементов массива равна = " + String.valueOf(sumResult));
                System.out.println(" ");
        }

    }

    public static int checkArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        int total = 0;           // в методе на вход подаем 2-х мерный массив arr и кидаем два исключения
        int value;
        int line;
        int cell;

        if (arr.length != 2 || arr[0].length != 4 || arr[1].length != 4) { // если не двухмерный, или не
            throw new MyArraySizeException();                              // по 4 столбца  кидаем исключение
        }                                                             // на несоответствие размеру

        for (int i = 0; i < 2; i++) {
            line = i;
            for (int w = 0; w < 4; w++) {
                cell = w;
                try {
                    value = Integer.parseInt(arr[i][w]);  // "перебираем" все элементы массива
                    total += value;
                } catch (IllegalArgumentException e) {    // "ловим" случай если не тип "String"
                    line++;
                    cell++;
                    String message = "в " + String.valueOf(line) + " строке, " + String.valueOf(cell) + " столбце";
                    throw new MyArrayDataException(message);
                }
            }
        }
        return total;
    }
}


