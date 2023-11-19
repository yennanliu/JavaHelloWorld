package com.yen.TddPlayGround.Bank.service;

import com.yen.TddPlayGround.Bank.bean.User;
import com.yen.TddPlayGround.Bank.repository.UserRepository;
import com.yen.TddPlayGround.Bank.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    AccountServiceImpl accountService;

    @BeforeEach
    public void before(){

        System.out.println("before");
    }

    @Test
    public void shouldGetBalanceIfUserExist(){

        User u1 = new User("id-01", 20.0);

        Mockito.when(userRepository.findById("id-01")).thenReturn(Optional.of(u1));

        Double res = accountService.getBalance("id-01");
        System.out.println(res);

        assertEquals(res, 20.0);
    }


}