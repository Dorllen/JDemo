package com.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    // 我们常用的
    protected static Logger logger = LoggerFactory.getLogger(LogTest.class);
    // 自带的
//    protected static java.util.logging.Logger log = java.util.logging.Logger.getLogger("Crawler");



    public static void main(String[] args) {
        // 以前
        logger.info("ABCXXX time={}", 123);
        // 现在

        System.Logger log2 = System.getLogger("Main2");
        log2.log(System.Logger.Level.INFO, "ABC2");

    }
}
