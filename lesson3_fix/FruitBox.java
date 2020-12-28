package lesson33;

public class FruitBox<T extends Fruit> {

    private T fruit;
    private int number;

    public FruitBox(T fruit, int number) {
        this.fruit = fruit;
        this.number = number;
    }

    public int getNumber() {   // геттер для количества фруктов в корзинке
        return number;
    }


    public void addFruit(int num) {

        number += num;
    }

    public void deductFruit(int num) {

        number -= num;
    }

    float getWeight() {
        float boxWeight = number * fruit.getWeight();
        return boxWeight;
    }

    public boolean compare(FruitBox<?> FruitBox2) {

        return Math.abs(this.getWeight()-FruitBox2.getWeight()) < 0.0001; //  * добавил !!!
    }


    public void shiftFruits(FruitBox<T> box, int num) {
        if (this.number < num) {
            System.out.println("Can't deduct so many fruits!");
        }
        if (box == this) {
            System.out.println("Can't deduct into itself!"); // * добавил !!!
        } else {
            this.deductFruit(num);
            box.addFruit(num);
        }
    }

    public void shiftAll(FruitBox<T> box) {
        if (box == this) {
            System.out.println("Can't deduct into itself!"); // * добавил
        } else {
            int num = this.number;
            this.deductFruit(num);
            box.addFruit(num);
        }
    }
}
