package com.example2;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PathTest{
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        Set<Map.Entry<Object, Object>> sets = properties.entrySet();
        for(Map.Entry<Object, Object> map : sets){
            System.out.println(map.getKey()+"   ->  "+map.getValue());
        }
    }
}
