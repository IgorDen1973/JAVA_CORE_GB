package lesson33;


public class BoxApp {
    public static void main(String[] args) {

        Apple apple1 = new Apple();
        Orange orange1 = new Orange();

        System.out.println(" ");

        System.out.println("Apple weight:  "+apple1.getWeight());
        System.out.println("Orange weight:  "+orange1.getWeight());

        System.out.println(" ");
        // Создадим несколько коробок с фруктами:

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
         // пересыпем 1 яблоко из первой корзины во вторую и сравним:
        appleBox1.shiftFruits(appleBox2,1);
        System.out.println("Amount for 1st Box: "+appleBox1.getNumber());
        System.out.println("Amount for 2nd Box: : "+appleBox2.getNumber());
        System.out.println(" ");
        System.out.println("Result of two boxes comparing (1st and 2nd):  "+appleBox1.compare(appleBox2));
        System.out.println("Result of two boxes comparing (1st and 3rd):  "+appleBox1.compare(orangeBox1));
        // пересыпем все яблоки из первой корзины во вторую:
        System.out.println(" ");
        appleBox1.shiftAll(appleBox2);
        System.out.println("Amount for 1st Box: "+appleBox1.getNumber());
        System.out.println("Amount for 2nd Box: : "+appleBox2.getNumber());

    }
}