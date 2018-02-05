package com.example.robot.three.impl;

import com.example.robot.three.Service;

public class ServiceImpl implements Service {
    @Override
    public void testService() {
        System.out.println(ServiceImpl.class);
    }
}
