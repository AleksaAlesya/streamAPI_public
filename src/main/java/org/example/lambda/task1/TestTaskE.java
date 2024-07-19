package org.example.lambda.task1;



import java.util.function.Function;
import java.util.function.Predicate;

public class TestTaskE {
    public static void main(String[] args) {



        Function<Integer,Integer> func = (a)->a-11;

        Predicate<Function<Integer, Integer>> tester= (a)->a.apply(10)<1;

        System.out.println(tester.test(func));
    }


    //todo //вывести результат выполнения лямбды тестер, приним. функтион с  аргументом 1





}
