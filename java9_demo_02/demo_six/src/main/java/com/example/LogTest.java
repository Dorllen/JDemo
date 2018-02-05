package com.example;

public class LogTest {

    private static System.Logger logger = System.getLogger("MyLog");
    public static void main(String[] args) {
        logger.log(System.Logger.Level.INFO, "Hello");
        logger.log(System.Logger.Level.INFO, "Hello2");
        logger.log(System.Logger.Level.INFO, "Hello2");

        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LogTest2 log2 = new LogTest2();
        log2.main(null);
    }
}
