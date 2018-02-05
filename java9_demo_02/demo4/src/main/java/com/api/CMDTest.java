package com.api;

public class CMDTest {
    public static void main(String[] args) {

        // jcmd CMDTest VM.stringtable
        while(true){
            String str = "abc";
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
