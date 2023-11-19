package com.yen.TddPlayGround.Bank.service;

import com.yen.TddPlayGround.Bank.bean.User;
import com.yen.TddPlayGround.Bank.service.impl.TransferServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/** unit test for TransferService */

@ExtendWith(MockitoExtension.class)
class TransferServiceTest {

    @Mock
    TransferService transferService;

    @Mock
    User user;

    @BeforeEach
    public void before(){
        System.out.println("setup ...");
    }

    @Test
    public void shouldUpdateBalanceWhenAdd(){

        User u1 = new User("id-01", 10.0);

        // mock
        //when(user.setBalance(10.0)).thenReturn(u1);
    }


    @Test
    public void test1(){
        System.out.println(123);
    }

}