package org.example;

import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {

            System.out.println("i = " + i);
        }

       Runnable multistatment=  ()->{
           System.out.println(254);
           System.out.println(254);
       };

        Runnable runnable =()-> System.out.println("no arg");


        BinaryOperator<Long> summ = (c,m)->c+m;


    }
}