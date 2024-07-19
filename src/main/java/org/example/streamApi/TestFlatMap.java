package org.example.streamApi;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class TestFlatMap {
    public static void main(String[] args) {
        //объединяем списки в один список
        List<Integer> together = Stream.of(asList(1,22), asList(1,244), asList(47,22)).flatMap(n->n.stream()).collect(toList());
        System.out.println(together);



    }


}
