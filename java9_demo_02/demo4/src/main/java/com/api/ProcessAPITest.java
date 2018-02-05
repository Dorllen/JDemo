package com.api;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProcessAPITest {

    public static void main(String[] args) {
        // 以前
        oldOne();
        // 现在
        System.out.println(ProcessHandle.current().pid());
    }


    public static void oldOne(){
        try {
            Process process = Runtime.getRuntime().exec("ps -l");
            if(process.waitFor() == 0){
                try(BufferedInputStream in = new BufferedInputStream(process.getInputStream())) {
                    byte[] b = new byte[in.available()];
                    in.read(b);
                    String value = new String(b);
                    if (value != null) {
                        System.out.println(value.split("\\r|\\n|\\r\\n"));
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

    }

    public static void oldThree(){

    }


}
