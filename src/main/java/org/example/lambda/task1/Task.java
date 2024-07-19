package org.example.lambda.task1;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static java.lang.ThreadLocal.withInitial;

public class Task {

    public  static  final  ThreadLocal<DateFormat> date = withInitial(()-> new SimpleDateFormat("dd-MMM-yyyy"));



    public static void main(String[] args) {
        Runnable r;
        JButton b;

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("поток 2");
            }
        });
        thread2.start();

        Thread thread = new Thread(
                () -> System.out.println("поток запущен"));
        thread.start();

        System.out.println(date);

        System.out.println(Quest2.date.get());

    }


}
