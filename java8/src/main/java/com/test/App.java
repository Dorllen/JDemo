package com.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File[] files = new File(".").listFiles(); // 项目的根目录，即java8目录
        File[] files2 = new File("/").listFiles(); // 计算机根目录
        File[] files3 = new File("～").listFiles(); // 计算机用户目录
        File[] files4 = new File("./src/main").listFiles(); //
        File files5 = new File("/demo1.txt"); // 计算机根目录

        Path path = Paths.get(".");
        Path path2 = Paths.get("/");
        Path path3 = Paths.get("./src/main");
        Path path4 = Paths.get("demo1.txt");
        Path path5 = Paths.get("/demo1.txt");
        System.out.println("======1=======");

        FileSystem fs = FileSystems.getDefault();
        System.out.println(fs.getRootDirectories());
        System.out.println("======2=======");

//        try {
//            System.out.println(new String(Files.readAllBytes(path4)));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println("======3=======");

        //  第三种
        InputStream in = App.class.getResourceAsStream("/demo1.txt");
        try {
            byte[] b = new byte[in.available()];
            in.read(b);
            System.out.println(new String(b));
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("======4=======");

        InputStream in2 = App.class.getResourceAsStream("demo1.txt"); // 放在src/main中无效的

        try {
            byte[] b_ = new byte[in2.available()];
            in.read(b_);
            System.out.println(new String(b_));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("======5=======");

        System.out.println( "Hello World!" );
    }
}
