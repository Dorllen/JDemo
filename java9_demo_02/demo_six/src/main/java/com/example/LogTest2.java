package com.example;

public class LogTest2 {

    private static System.Logger logger = System.getLogger("MyLog");
    public void main(String[] args) {
        logger.log(System.Logger.Level.INFO, "Hello3");
        logger.log(System.Logger.Level.INFO, "Hello3");
        logger.log(System.Logger.Level.INFO, "Hello3");
    }
}
