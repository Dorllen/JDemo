package com.example1;


//import sun.management.VMManagement;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static java.lang.System.out;

public class ProcessHandleTest {
    public static void main(String[] args) throws NoSuchFieldException {

        System.out.println(Runtime.version().toString());
        System.out.println(Runtime.version().major());
        System.out.println(Runtime.version().minor());
        System.out.println(Runtime.version().security());



        ProcessHandle p = ProcessHandle.current();
        out.println(p.getClass()+" "+p.pid());
        p.parent().stream().map(a ->{return a.getClass()+" "+a.pid();}).forEach(out::println);
        p.children().parallel().forEach(out::println);
        p.descendants().parallel().forEach(out::println);

//        ProcessHandle.allProcesses().forEach(out::println);

        System.out.println();

        ProcessHandle.Info info = ProcessHandle.current().info();
        System.out.println(info.totalCpuDuration().orElse(null));
        System.out.println(info.command());
        System.out.println(info.commandLine());

        // old


        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();// RuntimeImpl
        Field jvm = runtime.getClass().getDeclaredField("jvm");
//        jvm.setAccessible(true);
//        sun.management.VMManagement mgmt = (VMManagement) jvm.get(runtime);// VMManagermentImpl
//        Method pid_method = mgmt.getClass().getDeclaredMethod("getProcessId");
//        pid_method.setAccessible(true);
//
//        int pid = (Integer) pid_method.invoke(mgmt);
//        System.out.println("Pid:"+pid);
    }
}
