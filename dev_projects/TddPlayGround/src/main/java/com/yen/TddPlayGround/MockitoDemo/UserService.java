package com.yen.TddPlayGround.MockitoDemo;

// https://kucw.github.io/blog/2020/2/spring-unit-test-mockito/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Optional<User> getUserById(Integer id){
        return userDao.findById(id);
    }

    public void insertUser(User user){
        userDao.save(user);
    }

}
