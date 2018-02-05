package com.example.robot.two;

public class User {
    public String name = "dongneng";
    int age = 18;

    @Override
    public String toString() {
        return getClass()+"["+this.name+","+this.age+"]";
    }
}
