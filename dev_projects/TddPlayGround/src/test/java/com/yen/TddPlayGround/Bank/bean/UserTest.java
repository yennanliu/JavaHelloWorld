package com.yen.TddPlayGround.Bank.bean;

import com.yen.TddPlayGround.Bank.service.TransferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/** unit test for User */

@ExtendWith(MockitoExtension.class)
class UserTest {

    @BeforeEach
    public void before(){
        System.out.println("setup ...");
    }

    @Test
    public void shouldInitUserWithZeroBalance(){

        User u1 = new User("id-001", 0.0);
        assertEquals(u1.getBalance(), 0.0);

        User u2 = new User("id-002", 0.0);
        assertEquals(u2.getBalance(), 0.0);
    }

    @Test
    public void shouldAddBalanceWhenAdd(){

        User u1 = new User("id-001", 0.0);
        u1.setBalance(u1.getBalance() + 10.0);
        assertEquals(u1.getBalance(), 10.0);
    }

    @Test
    public void shouldMinusBalanceWhenMinus(){

        User u1 = new User("id-001", 0.0);
        u1.setBalance(u1.getBalance() - 10.0);
        assertEquals(u1.getBalance(), -10.0);
    }

}