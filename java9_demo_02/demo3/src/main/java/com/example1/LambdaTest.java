package com.example1;

import java.util.Set;

public class LambdaTest {
    public static void main(String[] args) {
        Set<String> sets = Set.of("abc","efg");
        sets.forEach(System.out::println);

        Set<Integer> values = Set.of(1,2,3,4,5,6,7);
        System.out.println(values.parallelStream().reduce(Integer::sum).get());
    }
}
