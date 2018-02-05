package com.example2;

import sun.reflect.Reflection;

import javax.management.relation.Relation;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class PropertyTest {
    public static void main(String[] args) {


        ResourceBundle bundle = ResourceBundle.getBundle("main");
        Enumeration<String> keys = bundle.getKeys();
        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            System.out.println(key+"="+bundle.getString(key));
        }

        System.out.println("------------");

        Properties properties = System.getProperties();
        Set<Map.Entry<Object, Object>> enumeration = properties.entrySet();
        for (Map.Entry<Object, Object> e : enumeration){
            System.out.println(e.getKey()+"="+e.getValue());
        }



//        Properties properties = new Properties();
//        try {
////            properties.load(PropertyTest.class.getResourceAsStream("./demo3/target/classes/main.properties"));
//            properties.load(new FileInputStream(new File("./demo3/target/classes/main.properties")));
//
//
//            ResourceBundle bundle = ResourceBundle.getBundle("main");
//
//            System.out.println(bundle.getString("name"));
//
//            System.out.println(properties.getProperty("name"));
////            System.out.println(new String(properties.getProperty("name").getBytes("iso8859-1")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
