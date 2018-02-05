package com.example1;

//import jdk.internal.misc.Unsafe;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.Enumeration;
import java.util.Properties;

public class VarHandleTest {
    public static void main(String[] args) {
        User u = new User();
        u.name = "dongneng";
        try {
            VarHandle varHandle = MethodHandles.lookup().findVarHandle(User.class, "name", String.class);
            varHandle.compareAndSet(u, "dongneng", "peng");// cas 中的Unsafe.compareAndSwapObject
            System.out.println(u.name);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static class User{
        public String name;
    }
//    static Unsafe unsafe;

}
