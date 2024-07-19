package org.example.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestReduce
{
    public static void main(String[] args) {
        Stream<Integer> streamint = Stream.of(1,2,3,4,5);

        int result = streamint.reduce((accomulaor,elem)-> accomulaor*elem).get();
        System.out.println(result);
        //1 2 3 4 5
        //accomulator 1   2   6   24  120  - накопитель результата
        // умножаем
        // elem       2   3   4   5

        int result1 = Stream.of(1,2,3,4,5).reduce((accomulaor,elem)-> accomulaor+elem).get();
        System.out.println(result1);
        //1 2 3 4 5
        //accomulator 1   3   6   10  15  - накопитель результата
        // складываем
        // elem       2   3   4   5

        int result2 = Stream.of(1,2,3,4,5).reduce(5,(accomulaor,elem)-> accomulaor+elem);
        System.out.println(result2);
        //1 2 3 4 5
        //первоначальное значение указали -5..... поэтому get()  не обязательно , т.к. результат в любом случае будет
        //accomulator 5   6   8   11  15  20 - накопитель результата
        // складываем
        // elem       1   2   3   4   5

        List<String> list = Arrays.asList("Привет!","как","дела");

        String string = list.stream().reduce("Маша!",(a,e)-> a + " " + e);
        System.out.println(string);

    }



}
