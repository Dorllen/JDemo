package com.example2;


//import sun.management.VMManagement;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class ProcessAPITest {

    public static void main(String[] args) {
        // 以前
        oldOne();
        oldTwo();

        // 现在
        System.out.printf("J9 API PID=%s \n", ProcessHandle.current().pid());
    }


    public static void oldOne(){
        try {
            Process process = Runtime.getRuntime().exec("jps -l");
            if(process.waitFor() == 0){
                try(BufferedInputStream in = new BufferedInputStream(process.getInputStream())) {
                    byte[] b = new byte[in.available()];
                    in.read(b);
                    String value = new String(b);
                    if (value != null) {
                        String[] values = value.split("\\n|\\r|\\r\\n");
                        for(String s : values){
                            if(s.endsWith(ProcessAPITest.class.getName())){
                                System.out.printf("oldOne PID=%s \n", s.split(" ")[0]);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void oldTwo(){
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        try {
            String value = runtimeMXBean.getName();
            System.out.printf("oldTwo PID=%s \n", value.split("@")[0]);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

//    public static void oldThree(){
//        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
//        try {
//            Field field = runtimeMXBean.getClass().getDeclaredField("jvm");
//            field.setAccessible(true);
//            VMManagement vm = (VMManagement) field.get(runtimeMXBean);
//            Method method = vm.getClass().getDeclaredMethod("getProcessId");
//            method.setAccessible(true);
//            int pid = (Integer) method.invoke(vm);
//            System.out.printf("oldThree PID=%s \n", pid);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
