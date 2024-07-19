package org.example.streamApi;

import java.sql.Array;
import java.util.Arrays;
import java.util.stream.Collector;

public class TestSorted {
    public static void main(String[] args) {
        int [] ar = {1,2,6,4,7,1,4};
        ar= Arrays.stream(ar).sorted().toArray();
        System.out.println(Arrays.toString(ar));

    }

}
