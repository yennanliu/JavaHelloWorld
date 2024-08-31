package com.yen.service.impl;

import com.yen.service.MyInterface;

// https://jimwayne.blogspot.com/2015/09/guice-dependency-imjection.html

public class Implementation_A implements MyInterface {

    @Override
    public String getClassName() {
        return "this is Implementation_A";
    }

}
