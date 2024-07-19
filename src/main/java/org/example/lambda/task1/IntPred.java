package org.example.lambda.task1;

import java.util.function.Predicate;

@FunctionalInterface
public interface IntPred {
    boolean test(Integer value);
}

 class TestCheck{
    final Integer value = 1;
     public static void main(String[] args) {
         TestCheck testCheck = new TestCheck();

         System.out.println(testCheck.check((IntPred) value -> value>10));
//         System.out.println(testCheck.check( value -> value>0));
    }


    boolean check(Predicate<Integer> predicate) {
         boolean  b= false;
        return b;
    }

    boolean check(IntPred predicate) {
        boolean  b= true;
        return b;
    }
}


//Не скомпилируется – вызовет ошибку из-за неоднозначности
