package com.api;

import java.util.*;

public class CollectionsTest {
    public static void main(String[] args) {
        // Set
        Set<String> set = new HashSet<>();
        set.add("Python");
        set.add("GO");
        System.out.println(set);

//        Set<String> set2 = Set.of();
//        Set<String> set2 = Set.of("Java","C#");
        Set<String> set2 = Set.of(new String[]{"Java","C#"});
        System.out.println(set2);

        // List
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        System.out.println(list);
        List<String> list2 = List.of("C","D");
        System.out.println(list2);
        List<String> list3 = List.of(new String[]{"E","F"});
        System.out.println(list3);

        // Map
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "dongneng");
        map.put("age","18");
        System.out.println(map);

//        Map<String, String> map2 = Map.of();
//        Map<String, String> map2 = Map.of("name","dongneng","age","19");
        Map<String, String> map2 = Map.ofEntries(Map.entry("name","dongneng"),Map.entry("age","20"));
        System.out.println(map2);

    }
}
