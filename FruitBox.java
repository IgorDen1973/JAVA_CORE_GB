package lesson33;

public class FruitBox<T extends Fruit> {

    private T fruit;                   // создаем переменную обобщенного класса Т
    private int number;                // количество фруктов в корзинке

    public FruitBox(T fruit , int number) {  // в конструкторе при создании задаем класс и количество в корзинке
        this.fruit = fruit ;
        this.number = number;
    }

    public int getNumber() {   // геттер для количества фруктов в корзинке
        return number;
    }


    public void addFruit(int num) {  // метод добавления фрукта в корзинку

        number += num;
    }

    public void deductFruit(int num) {    // метод изъятия фрукта из корзинки

        number -= num;
    }

    float getWeight() {               // подсчет веса фруктов в корзинке , getWeight тут из суперкласса Fruit
        float boxWeight = number * fruit .getWeight();
        return boxWeight;
    }

    public boolean compare(FruitBox<?> FruitBox2) {  // <?> позволит сравнивать коробки с любыми фруктами

        return this.getWeight() == FruitBox2.getWeight(); // FruitBox2 - вторая для сравнения корзинка
    }


    public void shiftFruits(FruitBox<T> box,int num) {   // <T> пересыпает только коробки с одинаковыми фруктами
        if (this.number < num) {                           // если поставить <?> то можно любые сравнить
            System.out.println("Can't deduct so many fruits!");
            return;                                             // этот метод позволяет пересыпать часть (не все)
        } else {                                                // фрукты из корзинки в корзинку
            this.deductFruit(num);
            box.addFruit(num);
        }
    }
    public void shiftAll(FruitBox<T> box) {  // <T> - ограничивает пересыпку всех фруктов из коробки в коробку
            int num = this.number;           // только для одного вида фруктов
            this.deductFruit(num);            // если поставить <?> то можно яблоки в апельсины сыпать
            box.addFruit(num);
        }
    }
