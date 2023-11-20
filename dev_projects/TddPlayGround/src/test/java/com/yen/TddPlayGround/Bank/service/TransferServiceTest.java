package com.yen.TddPlayGround.Bank.service;

import com.yen.TddPlayGround.Bank.bean.User;
import com.yen.TddPlayGround.Bank.repository.UserRepository;
import com.yen.TddPlayGround.Bank.service.impl.TransferServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

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

    User u1;
    User u2;
    User u3;
    User u4;
    User u5;


    @BeforeEach
    public void before(){

        System.out.println("setup ...");
        u1 = new User("id-01", 10.0);
        u2 = new User("id-02", 10.0);
        u3 = new User("id-03", -10.0);
        u4 = new User("id-04", 30.0);
        u5 = new User("id-05", 30.0);
    }

    @Test
    public void depositShouldAddBalance(){

        // mock
        Mockito.when(userRepository.save(any(User.class)))
                .thenReturn(u1);
        // run
        transferService.deposit(u1, 10.0);
        // verify
        assertEquals(u1.getBalance(), 20.0);
    }

    @Test
    public void withdrawShouldMinusBalance(){

        // mock
        Mockito.when(userRepository.save(any(User.class)))
                .thenReturn(u1);
        // run
        transferService.withdraw(u1, 10.0);
        // verify
        assertEquals(u1.getBalance(), 0.0);
    }

    @Test
    public void shouldUpdateBalanceWhenAdd(){

        // mock
        Mockito.when(userRepository.save(any(User.class))).thenReturn(u1);
        // run
        transferService.updateBalance(u1, 10.0);
        // verify
        verify(userRepository, times(1)).save(u1);
        assertEquals(u1.getBalance(), 10.0);
    }

    @Test
    public void transferShouldUpdateBalance(){

        // mock
        Mockito.when(userRepository
                .save(any(User.class)))
                .thenReturn(new User("id-01", 20.0));
        // run
        String res = transferService.transfer(u1, u2, 10);
        // verify
        assertEquals(res, "transfer 10.0 from id-01 to id-02");
    }

    @Test
    public void shouldNotTransferIfNotEnoughBalance(){

        // mock
        Mockito.when(userRepository.save(any(User.class))).thenReturn(null);

        // run
        String res = transferService.transfer(u1, u2, 20.0);
        // verify
        assertEquals(res, "transfer failed, not enough balance");

        // run
        String res2 = transferService.transfer(u3, u2, 20.0);
        // verify
        assertEquals(res2, "transfer failed, not enough balance");
    }

    @Test
    public void shouldAggregateToResultMultipleTransaction(){

        // mock
        Mockito.when(userRepository.save(any(User.class))).
                thenReturn(u1);
        // run
        String res1 = transferService.transfer(u1, u2, 1.0);
        String res2 = transferService.transfer(u1, u2, 2.0);
//        System.out.println(res1);
//        System.out.println(res2);
//        System.out.println(u1.getBalance());
        // verify
        assertEquals(u1.getBalance(), 7.0);
        assertEquals(u2.getBalance(), 13.0);
    }


    @Test
    public void getUserById() throws Exception {

        // mock
        Mockito.when(userRepository.findById("id-01"))
                .thenReturn(Optional.of(u1));

        // run
        User user = transferService.getUserById("id-01");
        // verify
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getId(), "id-01");
        assertEquals(user.getBalance(), 10);
    }

}