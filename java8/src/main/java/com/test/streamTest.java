package com.test;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class streamTest {
    public static void main(String[] args) {
//        infiniteStream();

//        infiniteStream2();

//        infiniteStream3();

//        patternStream();

//        fileStream();

//        someStreamMethod();

//        intStream();

    }

    private static void intStream() {
        IntStream range = IntStream.builder().build();//range(0, 5);
        range.forEach(System.out::println);
    }

    private static void someStreamMethod() {
        User u = new User(1);
        User u2 = new User(2);
        User u3 = new User(3);
//        Stream<User> stream = Stream.of(u, u2 ,u3 ,u ,u).distinct();
        Stream<User> stream = Stream.of(u, u2 ,u3 ,u ,u).skip(7);// skip大于size则返回，limit大于size也没关系
        stream.forEach(System.out::println);
    }

    private static void fileStream() {
        try(Stream<String> lines = Files.lines(Paths.get("src/main/java/demo1.txt"))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void patternStream() {
        Stream<String> stream = Pattern.compile(" ").splitAsStream("Java Is Good Language");
        stream.forEach(System.out::println);
    }

    private static void infiniteStream3() {
        // 无限随机树
        Stream<Double> randoms = Stream.generate(Math::random);
//        randoms.forEach(System.out::println);
        System.out.println(randoms.findAny().get());
//        System.out.println(randoms.findFirst().get());
    }

    private static void infiniteStream2() {
        // 无限序列
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        integers.forEach(System.out::println);
    }

    private static void infiniteStream() {
        // 无限流
        Stream<String> stream = Stream.generate(() -> "abc");
        stream.forEach(System.out::println);
    }

    public static class User{
        int id;
        User(int id){
            this.id = id;
        }

        @Override
        public String toString() {
            return "[User,id="+id+"]";
        }
    }
}
