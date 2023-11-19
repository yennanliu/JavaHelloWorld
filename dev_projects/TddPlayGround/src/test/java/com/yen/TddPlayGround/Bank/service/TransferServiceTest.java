package com.yen.TddPlayGround.Bank.service;

import com.yen.TddPlayGround.Bank.bean.User;
import com.yen.TddPlayGround.Bank.service.impl.TransferServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/** unit test for TransferService */

@ExtendWith(MockitoExtension.class)
class TransferServiceTest {

    @Mock
    TransferService transferService;

//    @MockBean
//    User user;

    @BeforeEach
    public void before(){
        System.out.println("setup ...");
    }

    @Test
    public void shouldUpdateBalanceWhenAdd(){

        User userMock = mock(User.class);

        TransferService transferService = new TransferServiceImpl(userMock);

        // Stub the behavior of the mock User
        when(userMock.setBalance(10.0)).thenReturn(10.0);

        // Call the method under test
        transferService.updateBalance(10.0);

        // Verify that the setBalance method was called with the correct argument
        verify(userMock, times(1)).setBalance(10.0);
    }


    @Test
    public void test1(){
        System.out.println(123);
    }

}