package org.example.lambda;

import java.util.*;
import java.util.concurrent.Callable;

public class StudentInfo {
    public static void main(String[] args) {
        Student student1 = new Student("Piter", 22, 2, 8.7);
        Student student2 = new Student("Lena", 28, 2, 8.7);
        Student student3 = new Student("Piter", 42, 3, 8.0);
        Student student4 = new Student("Piter", 52, 4, 8.7);
        Student student5 = new Student("Piter", 24, 2, 6.8);
        Student student6 = new Student("Piter", 27, 1, 8.7);


        List<Student> studentList = new ArrayList<>(Arrays.asList(
                student1,
                student2,
                student3,
                student4,
                student5,
                student6));


        printStCheck(studentList, new CheckOverGrade() {
//использ класс, кот имплементирует функциональный интерфейс
            // так не хорошо, т.к. в классе надо пропис. параметры
            // такой класс лучше не создавать, т.к. м. использваться только 1 раз
        });

// испoльзуем анонимный класс - интерфейс
        printStCheck(studentList, new StudentCheck() {
            @Override
            public boolean check(Student s) {
                return s.getAge()<30;
            }
        });

        System.out.println("------");


        printStCheck(studentList, new StudentCheck() {
            @Override
            public boolean check(Student s) {

                return s.getCourse()<3;
            }
        });
        System.out.println("------");

        //использование лямбда-выражения
        printStCheck(studentList,
                s -> s.getCourse()>2 && s.getAge()<50 && s.avgGrade>7);

        //если несколько операторов, то retern обязательно и {}
        printStCheck(studentList,
                s -> {
                    System.out.println("проверка " +s);
                    return s.getCourse()>2 && s.getAge()<50 && s.avgGrade>7;});



        //если в лямбде ипользуются {}то пишем retern b ;
        StudentCheck studentCheck = s-> {return s.getCourse()>2 && s.getAge()<50 && s.avgGrade>7;};



        printStCheck(studentList,studentCheck);

//        printStDif(studentList, 8.5,20,3);




        System.out.println("++++++++++++");
        // сортировка по возрасту используя анонимный ккласс
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println(studentList);
        System.out.println("++++++++++++");

        //сортировка по возрасту и курсу
        Collections.sort(studentList, (st1,st2)->(st1.getAge()-st2.getAge())& (st1.getCourse()-st2.getCourse()));

        System.out.println(studentList);
        //сортировка по курсу
        Collections.sort(studentList,(s1,s2) -> (s1.getCourse()-s2.getCourse()));
        System.out.println(studentList);




}

    // метод принимает на вход лист и  интерфейс с  методом любой фильтрации
    static  void printStCheck(List <Student> list, StudentCheck studentCheck){
        for (Student student : list) {
           if( studentCheck.check(student)){
               System.out.println(student);
           }
        }
    }

//   static void printStUnderAge(List <Student> list, int age){
//        for (Student s : list) {
//            if (s.getAge()<age){
//                System.out.println(s);
//            }
////        }
//    }
//    static void printStCourse(List <Student> list, int course){
//        for (Student s : list) {
//            if (s.getAge()>course){
//                System.out.println(s);
//            }
////        }
//    }
//    static void printStGradle(List <Student> list, double avgGrade){
//        for (Student s : list) {
//            if (s.avgGrade> avgGrade){
//                System.out.println(s);
//            }
////        }
//    }
//
//    static void printStDif(List <Student> list, double avgGrade,int age, int course){
//        for (Student student : list) {
//            if (student.avgGrade>avgGrade && student.getAge()>age &&student.getCourse()<course)
//                System.out.println(student);
//        }
//    }
    }





