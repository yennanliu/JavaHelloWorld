package com.yen.service.impl;

//import static org.junit.jupiter.api.Assertions.*;

import com.yen.service.RegisterService;
import org.junit.Assert;
import org.junit.Before;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

//@RunWith(MockitoExten)
//@ExtendWith(Mockito.class)
class RegisterServiceImplTest {

    private ConcurrentHashMap<String, Object> map;

    private RegisterServiceImpl registerService;

    @BeforeEach
    public void setup(){

        map = new ConcurrentHashMap<>();
        map.put("address-a", "key-a");

        registerService = new RegisterServiceImpl(map);
    }

    @Test
    public void shouldReturnTrueIfExist(){

        String myAddress = "address-a";
        Assertions.assertEquals(registerService.isExisted(myAddress), true);
    }

    @Test
    public void shouldReturnFalseIfNotExist(){

        String myAddress = "address-b";
        Assertions.assertEquals(registerService.isExisted(myAddress), false);
    }

    @Test
    public void shouldReturnTrueIfAddressNotInMemory(){

        String myAddress = "address-c";
        Assertions.assertEquals(registerService.register(myAddress), true);

    }

    @Test
    public void shouldReturnFalseIfAddressInMemory(){

        String myAddress = "address-a";
        Assertions.assertEquals(registerService.register(myAddress), false);

    }

    @Test
    public void shouldReturnFalseIfSaveOverTenAddress(){

        for (int i = 0; i < 10; i++){
            map.put(String.valueOf(i), UUID.randomUUID().toString());
        }

        String myAddress = "address-a";
        System.out.println(map.keySet().size());
        Assertions.assertEquals(registerService.register(myAddress), false);
    }

    @Test
    public void shouldReturnTrueIfNormalAddress(){

        //String myAddress = "dev.com/...";
        String myAddress = "127.0.0.1";
        Assertions.assertEquals(registerService.validate(myAddress), true);
    }



}