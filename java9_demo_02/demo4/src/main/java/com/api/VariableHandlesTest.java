package com.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class VariableHandlesTest {
    @Data
    @AllArgsConstructor
    static class User{
        public String name;
        public int age;
    }
    public static void main(String[] args) {
        try {
            User user = new User("dongneng", 18);
            System.out.println(user);

            VarHandle varHandle = MethodHandles.lookup().findVarHandle(
                    User.class, "name", User.class.getDeclaredField("name").getType());
            varHandle.compareAndSet(user, user.name, "zhaoyun");

            System.out.println(user);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}