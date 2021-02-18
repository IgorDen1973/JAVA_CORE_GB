package ru.geekbrains.JAVA2.lesson9;


public class Courses implements Course{

    String name;

    public Courses(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name+" ";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Courses other = (Courses) obj;
        if (name != other.getName())
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result+name.hashCode();
        return result;
    }





}
