package lesson33;

abstract class Fruit {

    private float weight;

    float getWeight() {       // создаем геттер , чтобы его потом использовать в обобщенном классе FruitBox

        return weight;
    }
}