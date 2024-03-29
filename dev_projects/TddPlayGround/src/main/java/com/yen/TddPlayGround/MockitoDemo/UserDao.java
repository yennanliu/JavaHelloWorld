package com.yen.TddPlayGround.MockitoDemo;

import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {

    public User getById(Integer id);

    public Integer insertUser(User user);
}
