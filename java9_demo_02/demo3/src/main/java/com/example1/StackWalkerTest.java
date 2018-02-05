package com.example1;

import sun.reflect.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.stream.Collectors;


public class StackWalkerTest {
    public static void main(String[] args) {
        run();
        System.out.println("---------");
        oldRun();
    }

    public static void run(){
        Class clz = Stack01.class;
        try {
            Method method = clz.getDeclaredMethod("test1", null);
            method.invoke(null, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void oldRun(){
        Class clz = Stack01.class;
        try {
            Method method = clz.getDeclaredMethod("test2", null);
            method.invoke(null, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    public static class Stack01{
        public static void test1(){
            Stack02.test1();
        }
        public static void test2(){
            Stack02.test2();
        }
    }

    public static class Stack02{
        public static void test1(){
//            StackWalker.getInstance().forEach(System.out::println);
            StackWalker.getInstance().walk(s -> s.collect(Collectors.toList())).forEach( w -> {
                System.out.println("Name："+w.getClassName()+"...Line:"
                        + w.getLineNumber()+"...MethodName:"+w.getMethodName());
            });
        }
        public static void test2(){
            int i = 0;
            while(true) {
                Object obj = Reflection.getCallerClass(i);
                System.out.println(obj);
                i++;
                if(obj==null){
                    break;
                }
            }
        }
    }
}
