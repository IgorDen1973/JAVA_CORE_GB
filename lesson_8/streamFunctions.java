package ru.geekbrains.JAVA2.lesson9;

import java.util.*;
import java.util.stream.Collectors;

public class streamFunctions {

    public static void main(String[] args) {

        List<Course> list1 = new ArrayList<>();
        list1.add(new Courses("курс.1"));
        list1.add(new Courses("курс.5"));
        list1.add(new Courses("курс.9"));
        list1.add(new Courses("курс.19"));

        List<Course> list2 = new ArrayList<>();
        list2.add(new Courses("курс.4"));
        list2.add(new Courses("курс.9"));
        list2.add(new Courses("курс.16"));

        List<Course> list3 = new ArrayList<>();
        list3.add(new Courses("курс.1"));
        list3.add(new Courses("курс.3"));
        list3.add(new Courses("курс.5"));
        list3.add(new Courses("курс.10"));
        list3.add(new Courses("курс.18"));

        List<Course> list4 = new ArrayList<>();
        list4.add(new Courses("курс.2"));
        list4.add(new Courses("курс.8"));


        List<Student> alumnado = new ArrayList<>(Arrays.asList(
                new Persons("Ivan", list1),
                new Persons("Alex", list2),
                new Persons("John", list3),
                new Persons("Dima", list4)

        ));
        System.out.println(" ");
        alumnado.forEach(System.out::println);

        System.out.println(" ");
        System.out.println("******************  1. СПИСОК УНИКАЛЬНЫХ КУРСОВ  ********************************************");
        System.out.println(" ");
        streamFunctions streamFunctions = new streamFunctions();
        System.out.println(streamFunctions.uniqueCourses(alumnado));
        System.out.println(" ");
        System.out.println("******************  2. СПИСОК САМЫХ ЛЮБОЗНАТЕЛЬНЫХ  *****************************************");
        System.out.println(" ");
        System.out.println(streamFunctions.theMostActive(alumnado));
        System.out.println(" ");
        System.out.println("**********************  3. СПИСОК ПОСЕЩАЮЩИХ КУРС  ******************************************");
        System.out.println(" ");
        Courses course1 = new Courses("курс.9");
        System.out.println(streamFunctions.atLeastOne(alumnado,course1));
        System.out.println("");

    }
    //         1.	Написать функцию, принимающую список Student и возвращающую список уникальных курсов,
    //              на которые подписаны студенты.

    public List<Course> uniqueCourses(List<Student> studentList) {
        return studentList.stream()
                .map(p -> p.getAllCourses())
                .flatMap(List::stream)
                .distinct()                        // так, как свой класс созданный , переопределяем HashCode+equals
                .collect(Collectors.toList());     // для корректой работы distinct() в классе Courses
    }


//              2.	Написать функцию, принимающую на вход список Student и возвращающую список из трех самых
//                  любознательных (любознательность определяется количеством курсов).

    public List<Student> theMostActive(List<Student> studentList) {
        return studentList.stream()
                .sorted((o1, o2) -> o2.getAllCourses().size() - o1.getAllCourses().size())
                .limit(3)   // берем первых троих
                .collect(Collectors.toList());
    }

    //          3.	Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список
    //              студентов, которые посещают этот курс.

    public List<Student> atLeastOne(List<Student> studentList, Courses course1) {
        return studentList.stream()
                .filter(m -> m.getAllCourses().contains(course1))
                .collect(Collectors.toList()); // так как на выходе метода List
    }
}

