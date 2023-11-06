//package com.yen.TddPlayGround.MockitoDemo;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.ImportResource;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ImportResource({"classpath*:application-context.xml"})
//class UserServiceTest {
//
//    @Autowired
//    private UserService userService;
//
//    @MockBean
//    private UserDao userDao;
//
//    @Test
//    public void testGetUserById(){
//
//        // DEFINE mocked element (UserDao) behavior
//        Mockito.when(userDao.findById(3)).thenReturn(Optional.of(new User(3, "I am Tim")));
//
//        User user = new User(3, "I am Tim");
//
//        assertNotNull(user);
//        assertEquals(user.getId(), new Integer(3));
//        assertEquals(user.getName(), "I am Tim");
//    }
//
//
//}