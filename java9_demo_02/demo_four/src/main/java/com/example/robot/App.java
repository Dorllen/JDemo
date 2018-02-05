package com.example.robot;

import com.alibaba.fastjson.JSONObject;

public class App {
    public static void main(String[] args) {
        // 一个引用外部jar包的案例
        JSONObject json = new JSONObject();
        json.put("name", "dongneng");
        json.put("age", 18);
        System.out.println(json.toJSONString());

        // 一个引用其他module的案例


        //  同名冲突怎办



        // 命名规则如何
    }
}
