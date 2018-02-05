package com.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class arrayStream {
    public static void main(String[] args) {
        Stream<Integer> values = Arrays.stream(new Integer[]{1,2,5,7}, 1, 3);
        values.forEach(System.out::println);
    }
}
