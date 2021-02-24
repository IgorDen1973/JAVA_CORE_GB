package lesson33;

import java.util.Arrays;

public class BoxApp {
    public static void main(String[] args) {

        System.out.println(" ");
        Integer array1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9 ,10};                       // * добавил
        String array2[] = {"item1", "item2", "item3", "item4"} ;                  // * добавил
        Double array3[] = {2.0, 5.3, 6.11, 32.0, 44.7, 66.1};                     // * добавил
        swap(array1,3,8);                                                  // * добавил
        swap(array2,1,3);                                                  // * добавил
        swap(array3,2,4);                                                  // * добавил

        Apple apple1 = new Apple();
        Orange orange1 = new Orange();

        System.out.println(" ");

        System.out.println("Apple weight:  "+apple1.getWeight());
        System.out.println("Orange weight:  "+orange1.getWeight());

        System.out.println(" ");


        FruitBox<Apple> appleBox1 = new FruitBox<Apple>(apple1, 10);
        System.out.println("Weight for 1st Box: "+appleBox1.getWeight()+"      Amount: "+appleBox1.getNumber());

        FruitBox<Apple> appleBox2 = new FruitBox<Apple>(apple1, 8);
        System.out.println("Weight for 2nd Box: "+appleBox2.getWeight()+"      Amount: "+appleBox2.getNumber());

        FruitBox<Orange> orangeBox1 = new FruitBox<Orange>(orange1, 6);
        System.out.println("Weight for 3rd Box: "+orangeBox1.getWeight()+"      Amount: "+orangeBox1.getNumber());
        System.out.println(" ");

        System.out.println("Result of two boxes comparing (1st and 3rd):  "+appleBox1.compare(orangeBox1));
        System.out.println("Result of two boxes comparing (1st and 2nd):  "+appleBox1.compare(appleBox2));
        System.out.println(" ");

        appleBox1.shiftFruits(appleBox2,1);

        appleBox2.shiftFruits(appleBox2,1); // * проверка пересыпки в саму себя


        System.out.println("Amount for 1st Box: "+appleBox1.getNumber());
        System.out.println("Amount for 2nd Box: : "+appleBox2.getNumber());
        System.out.println(" ");
        System.out.println("Result of two boxes comparing (1st and 2nd):  "+appleBox1.compare(appleBox2));
        System.out.println("Result of two boxes comparing (1st and 3rd):  "+appleBox1.compare(orangeBox1));
        // пересыпем все яблоки из первой корзины во вторую:
        System.out.println(" ");
        appleBox1.shiftAll(appleBox2);

        appleBox1.shiftAll(appleBox1);   // * проверка пересыпки в саму себя

        System.out.println("Amount for 1st Box: "+appleBox1.getNumber());
        System.out.println("Amount for 2nd Box: : "+appleBox2.getNumber());

    }

    public static void swap(Object[] array, int x1, int x2){          // * добавил
        System.out.println("Before: "+ Arrays.toString(array));
        Object o = array[x1];
        array[x1]=array[x2];
        array[x2]=o;
        System.out.println("After:  "+Arrays.toString(array));
        System.out.println(" ");
    }


}