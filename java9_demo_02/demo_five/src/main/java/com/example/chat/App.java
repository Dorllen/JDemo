package com.example.chat;

import com.alibaba.fastjson.JSONObject;
//import com.example.robot.four.Address;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
//import com.example.robot.Util;
//import jdk.internal.math.FloatConsts;
//import sun.misc.Unsafe;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
//        Util.get();// 访问另一个module

        // 访问fastjson 验证 transitive
//        System.out.println(JSONObject.class);

        // 访问其他module内部not exports module 访问不了
//        com.example.robot.one.App.main(null);

        // 访问系统内部Unsafe 需要引入模块
//        System.out.println(Unsafe.class);

        // 访问
//        System.out.println(FloatConsts.EXP_BIAS);


        // 利用反射 获得属性
        try {
            Class clz = Class.forName("com.example.robot.two.User");//反射
            System.out.println(clz);// 可以获得对象
//            Object obj = clz.newInstance();//  过时，不推荐使用
            Constructor constructor = clz.getConstructor(null);
            constructor.setAccessible(true);// Unable to make public com.example.robot.two.User() accessible: module demo.four does not "exports com.exam
            Object obj = constructor.newInstance(null);
            System.out.println(obj);

            Field fieldName = clz.getField("name");
            Object nameValue = fieldName.get(obj);
            System.out.println(nameValue);

            Field fieldAge = clz.getDeclaredField("age");
            fieldAge.setAccessible(true);

            Object ageValue = fieldAge.get(obj);
            System.out.println(ageValue);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        // 测试module问题
//        System.out.println(Address.class);


    }
}
