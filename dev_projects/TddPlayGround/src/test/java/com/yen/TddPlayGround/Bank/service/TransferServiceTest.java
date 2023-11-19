package com.yen.TddPlayGround.Bank.service;

import com.yen.TddPlayGround.Bank.bean.User;
import com.yen.TddPlayGround.Bank.repository.UserRepository;
import com.yen.TddPlayGround.Bank.service.impl.TransferServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

/** unit test for TransferService */

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class TransferServiceTest {

    @Mock
    TransferService transferService;

    @MockBean
    UserRepository userRepository;


    @BeforeEach
    public void before(){
        System.out.println("setup ...");
    }

    @Test
    public void shouldUpdateBalanceWhenAdd(){

        User userMock = mock(User.class);

        UserRepository userRepository = mock(UserRepository.class);

        // TODO : fix below
        TransferService transferService = new TransferServiceImpl(userRepository);
        //transferService = Mockito.mock(TransferService.class);

        // Stub the behavior of the mock User
        when(userMock.setBalance(10.0)).thenReturn(10.0);

        // Call the method under test
        transferService.updateBalance(userMock, 10.0);

        // Verify that the setBalance method was called with the correct argument
        verify(userMock, times(1)).setBalance(10.0);

        assertEquals(userMock.setBalance(10.0), 10.0);
    }

    @Test
    public void transferShouldUpdateBalance(){

        // mock
        UserRepository userRepository = mock(UserRepository.class);
        User userMock = mock(User.class);

        //when(userRepository.save(userMock)).thenReturn(new User("id-01", 20.0));
        Mockito.when(userRepository.save(any())).thenReturn(new User("id-01", 20.0));

        User u1 = new User("id-01", 10.0);
        User u2 = new User("id-02", 10.0);

        transferService.transfer(u1, u2, 10);

        System.out.println(u1);
        System.out.println(u2);
    }


    @Test
    public void getUserById() throws Exception {

        Mockito.when(userRepository.findById("id-01"))
                .thenReturn(Optional.of(new User("id-01", 0.0)));

        User user = transferService.getUserById("id-01");

        //檢查結果
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getId(), "id-01");
    }

    @Test
    public void test1(){
        System.out.println(123);
    }

}