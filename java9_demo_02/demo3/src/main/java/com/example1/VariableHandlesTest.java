package com.example1;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class VariableHandlesTest {
    static class User{
        User(String name, int age){this.name= name; this.age=age;}
        public String name;
        public int age;
        @Override
        public String toString() {
            return "User["+this.name+"  "+this.age+"]";
        }
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
