package com.yen.TddPlayGround.Bank.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/** unit test for TransferService */

@ExtendWith(MockitoExtension.class)
class TransferServiceTest {

    @Mock
    TransferService transferService;

    @BeforeEach
    public void before(){
        System.out.println("setup ...");
    }

    @Test
    public void shouldInitUserWithZeroBalance(){

        // mock
        Mockito.mock(TransferService.class);


    }

    @Test
    public void test1(){
        System.out.println(123);
    }

}