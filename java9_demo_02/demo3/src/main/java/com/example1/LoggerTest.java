package com.example1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerTest {
    public static Logger logger = Logger.getLogger(LoggerTest.class.getName());
    public static void main(String[] args) {
        System.Logger.Level.valueOf(Level.ALL.getName());
        logger.info(() ->{
            return "abc";
        });
        logger.info("Hello My Boy: {1}, {}");
    }
}
