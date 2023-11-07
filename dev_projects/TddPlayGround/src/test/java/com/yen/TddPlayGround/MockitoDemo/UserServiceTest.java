package com.yen.TddPlayGround.MockitoDemo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

// https://kucw.github.io/blog/2020/2/spring-unit-test-mockito/

@RunWith(SpringRunner.class)
@SpringBootTest
//@ImportResource({"classpath*:application-context.xml"})
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserDao userDao;

    @Test
    public void testGetUserById_1(){

        // DEFINE mocked element (UserDao) behavior
        Mockito.when(userDao.getById(3))
                .thenReturn(new User(3, "I am Tim"));

        User user1 = new User(3, "I am Tim");

        assertNotNull(user1);
        assertEquals(user1.getId(), new Integer(3));
        assertEquals(user1.getName(), "I am Tim");
    }

    @Test
    public void testGetUserById_2(){

        // DEFINE mocked element (UserDao) behavior
        Mockito.when(
                userService.getUserById(Mockito.anyInt()))
                .thenReturn(new User(3, "I'm mock"));

        User user1 = userService.getUserById(3);
        User user2 = userService.getUserById(200);

        assertEquals(user1.getId(), new Integer(3));
        assertEquals(user2.getId(), new Integer(3));
    }

    @Test
    public void testGetUserById_3(){

        // DEFINE mocked element (UserDao) behavior
        Mockito.when(
                userService.getUserById(3))
                .thenReturn(new User(3, "I'm mock"));

        User user1 = userService.getUserById(3);
        User user2 = userService.getUserById(200);

        assertEquals(user1.getId(), new Integer(3));
        assertNull(user2);
    }

    @Test
    public void testInsertUser1(){

        Mockito.when(
                userService.insertUser(Mockito.any(User.class)))
                .thenReturn(100);

        Integer i = userService.insertUser(new User()); //會返回100

        assertEquals(i, 100);
    }

    @Test
    public void testGetUserByIdThrowException(){

        Mockito.when(
                userService.getUserById(9)).thenThrow(
                        new RuntimeException("mock throw exception"));

        //User user = userService.getUserById(9); //會拋出一個RuntimeException
        // https://blog.csdn.net/qq_44336097/article/details/116005808
        assertThrows(RuntimeException.class, () -> {
            userService.getUserById(9);
        });
    }


}