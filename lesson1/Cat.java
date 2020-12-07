package ru.geekbrains.JAVA2.lesson1;

class Cat implements Athletic {

    private String name;
    private int maxDistance;
    private double maxHeight;

    public Cat(String name, int maxDistance, double maxHeight) {
        this.name = name;
        this.maxDistance = maxDistance;   // решил с косоли запрашивать и устанавливать при инициализации
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean run(int input) {
        if (input > this.maxDistance) {
            System.out.println("Cat " + this.name + " has FAILED RUNNING for distance of " + input + " meters....");
            return false;
        } else System.out.println("Running for Cat " + this.name + " has successfully completed");
        return true;
    }

    @Override
    public boolean jump(double input) {
        if (input > this.maxHeight) {
            System.out.println("Cat " + this.name + " has FAILED JUMPING at high of " + input + " meters...");
            return false;
        } else System.out.println("Jumping for Cat " + this.name + " has successfully completed");
        return true;
    }
}
