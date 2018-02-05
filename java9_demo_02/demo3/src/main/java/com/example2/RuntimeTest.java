package com.example2;

public class RuntimeTest {
    public static void main(String[] args) {
        Runtime.Version version = Runtime.version();
        System.out.println("JDK:"+version.toString());
        ProcessHandle.Info info = ProcessHandle.current().info();
        System.out.println("CpuDuration:"+info.totalCpuDuration().get());
        System.out.println(info.startInstant().get());
        System.out.println(ProcessHandle.current().isAlive());
    }
}
