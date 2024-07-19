package org.example.streamApi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Test {
    public static void main(String[] args) {

    int [] array = {5,3,4,6,8};
    // если число делится на 3, то его разделить на 3 и собрать в массив чисел
        // получим[5, 1, 4, 2, 8]
      array=  Arrays.stream(array).map(e ->{
            if(e%3==0){
                e=e/3;
              }
            return e;}).toArray();
//        System.out.println(Arrays.toString(array));

        Set <String> set = new TreeSet<>();
        set.addAll(asList("привет", "как дела","пока", "ок", "привет"));
        System.out.println("treeset" + set);

        List <String> list =set.stream().map(e->e.toUpperCase()).collect(toList());
        System.out.println(list);

        //отсортированный список длин слов, только уникальные
        Set <Integer> set1 = set.stream()
                .map(e->e.length())
                .collect(Collectors.toSet());
        System.out.println("treeset" + set1);

        // преобразует в буквы верх. регистра
        List <String> list1 = Stream.of("а","1сс","б","1дд")
                .map(s-> s.toUpperCase())
                .collect(toList());
        System.out.println("list1" + list1);


//        System.out.println("список строк и нужно найти среди них все, начинающиеся с цифры."
//        );
//        List <String> list2 = Stream.of(list1).filter(v->Character.isDigit(v.charAt(1))).collect(toList());


        //объединяем списки в один список
        List <Integer> together = Stream.of(asList(1,22), asList(1,244), asList(47,22)).flatMap(n->n.stream()).collect(toList());
        System.out.println(together);

        //Метод reduce - складываем все элеменнты списка и добавим к ним 10
        Integer summ = Stream.of(1,3,4,7).reduce(10,(a,b)->a+b).intValue();
        System.out.println(summ);

    }
}
