package com.yen.example0.service;

// https://jimwayne.blogspot.com/2015/09/guice-dependency-imjection.html

// NOTE !!! use google's inject

import com.google.inject.Inject;
//import javax.inject.Inject;

public class RunningService {

    private MyInterface impl;

    /**
     * inject MyInterface to RunningService
     * <p>
     * -> add @Inject at constructor
     */
    @Inject
    public RunningService(MyInterface myInterface) {
        this.impl = myInterface;
    }

    public String print() {
        String msg = "msg from impl : " + impl.getClassName();
        System.out.println(msg);
        return msg;
    }

}
