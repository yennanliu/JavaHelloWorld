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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

        // mock
//        User _u1 = new User("id-001", 10.0);
//        when(user.updateBalance(10.0)).thenReturn(10.0);
//
//        Mockito.mock(TransferService.class);
//        User u1 = new User();
//        Double res1 = transferService.updateBalance(u1, 10.0);
//        //Double res1 = new TransferServiceImpl().updateBalance(u1, 10.0);
//        System.out.println(res1);
//        System.out.println(u1.toString());

//        // Create a real instance of User or use a spy if needed
//        User u1 = new User("id-001", 10.0);
//        System.out.println(">>> u1 = " + u1);
//
//        // Call the actual method you are testing
//        Double res1 = transferService.updateBalance(u1, 10.0);
//
//        // Assert or verify the result based on the behavior of the method
//        // ...
//
//        // Optionally, you can use assertions to check the state of the User instance
//        assertEquals(20.0, res1);

        // Mock the TransferService interface
        TransferService transferService = mock(TransferService.class);

        // Create a real instance of User or use a spy if needed
        User u1 = new User("id-001", 10.0);

        // Stub the method of the mocked TransferService
        when(transferService.updateBalance(u1, 10.0)).thenReturn(20.0);

        // Call the actual method you are testing
        Double res1 = transferService.updateBalance(u1, 10.0);

        // Assert or verify the result based on the behavior of the method
        assertEquals(20.0, res1, 0.01);

        // Optionally, you can use assertions to check the state of the User instance
        assertEquals(20.0, u1.getBalance(), 0.01);
    }

    @Test
    public void test1(){
        System.out.println(123);
    }

}