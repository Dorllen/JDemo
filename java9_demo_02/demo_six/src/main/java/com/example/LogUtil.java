package com.example;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class LogUtil {

    // http://javasampleapproach.com/java/java-9/java-9-platform-logging-and-service

    public static class MyLogFinder extends System.LoggerFinder{

        @Override
        public System.Logger getLogger(String name, Module module) {
            System.out.println(this);
            if("MyLog".equals(name)){
                return new MyLog();
            }
            throw new IllegalArgumentException("Logger is not found!!!");
        }
    }

    public static class MyLog implements System.Logger{

        @Override
        public String getName() {
            return "MyLog";
        }

        @Override
        public boolean isLoggable(Level level) {
            switch (level) {
                case OFF:
                case TRACE:
                case DEBUG:
                case INFO:
                case WARNING:
                case ERROR:
                case ALL:
                default:
                    return true;
            }
        }

        @Override
        public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
            System.out.printf("Log from MyLog [%s]: %s - %s%n", level, msg, thrown);
        }

        @Override
        public void log(Level level, ResourceBundle bundle, String format, Object... params) {
            System.out.printf("Log from MyLogger [%s]: %s%n", level, MessageFormat.format(format, params));
        }
    }
}
