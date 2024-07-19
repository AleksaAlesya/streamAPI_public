package org.example.lambda.task1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static java.lang.ThreadLocal.withInitial;

public class Quest2 {
    public  static   final  ThreadLocal <DateFormat> date = withInitial(()->new SimpleDateFormat("dd-MMM-yyyy"));


    public static void main(String[] args) {
        System.out.println(date);
    }

}
