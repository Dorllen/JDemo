package com.example1;

public class SpinTest {

    // spinlocks
    public static void main(String[] args) {
        System.out.println("True");
        Thread.onSpinWait();
        System.out.println("False");
    }
}
