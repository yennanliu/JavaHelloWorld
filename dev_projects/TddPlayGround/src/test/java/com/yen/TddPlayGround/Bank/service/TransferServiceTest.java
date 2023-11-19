package com.yen.TddPlayGround.Bank.service;

import com.yen.TddPlayGround.Bank.bean.User;
import com.yen.TddPlayGround.Bank.repository.UserRepository;
import com.yen.TddPlayGround.Bank.service.impl.TransferServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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

// https://github.com/teddysmithdev/pokemon-review-springboot/blob/master/src/test/java/com/pokemonreview/api/service/PokemonServiceTests.java

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class TransferServiceTest {

    // InjectMocks : for inject service which will use Dao/repository
    @InjectMocks // https://blog.csdn.net/yangyangrenren/article/details/118555559
    TransferServiceImpl transferService;

    // Mock : for mock Dao/repository
    @Mock
    UserRepository userRepository;


    @BeforeEach
    public void before(){
        System.out.println("setup ...");
    }

    @Test
    public void shouldUpdateBalanceWhenAdd(){

        // mock
//        User userMock = mock(User.class);
//        UserRepository userRepository = mock(UserRepository.class);

        // TODO : fix below
        //TransferService transferService = new TransferServiceImpl(userRepository);
        //transferService = Mockito.mock(TransferService.class);

        // Stub the behavior of the mock User
        //when(userMock.setBalance(10.0)).thenReturn(10.0);

        User u1 = new User("id-01", 10.0);

        Mockito.when(userRepository.save(any(User.class)))
                .thenReturn(u1);

        // Call the method under test
        transferService.updateBalance(u1, 10.0);

        // Verify that the setBalance method was called with the correct argument
        verify(userRepository, times(1)).save(u1);

        assertEquals(u1.getBalance(), 10.0);
    }

    @Test
    public void transferShouldUpdateBalance(){

        // mock
//        UserRepository userRepository = mock(UserRepository.class);
//        User userMock = mock(User.class);
        //when(userRepository.save(userMock)).thenReturn(new User("id-01", 20.0));
        Mockito.when(userRepository
                .save(any(User.class)))
                .thenReturn(new User("id-01", 20.0));

        User u1 = new User("id-01", 10.0);
        User u2 = new User("id-02", 10.0);

        String res = transferService.transfer(u1, u2, 10);

        System.out.println(res);
        System.out.println(u1);
        System.out.println(u2);

        assertEquals(res, "transfer 10.0 from id-01 to id-02");
    }



    @Test
    public void getUserById() throws Exception {

        User u1 = new User("id-01", 20.0);

        Mockito.when(userRepository.findById("id-01"))
                .thenReturn(Optional.of(u1));

        User resultUser = transferService.getUserById("id-01");

        System.out.println(resultUser.toString());

        //check result
        Assert.assertNotNull(resultUser);
        Assert.assertEquals(resultUser.getId(), "id-01");
        assertEquals(resultUser.getBalance(), 20.0);
    }

    @Test
    public void test1(){

        System.out.println(123);
    }

}