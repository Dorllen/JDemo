package com.example1;


import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class HttpClientTest {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.New(new URL("http://openjdk.java.net/jeps/247"));
            InputStream in;
            in = client.getInputStream();
            if(in!=null) {
                byte[] b = new byte[in.available()];
                in.read(b);
                System.out.println(new String(b));
            }

            Thread.onSpinWait();

            OutputStream out = client.getOutputStream();
            if(out!=null){
                System.out.println("Out is not NULL!!!");
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
