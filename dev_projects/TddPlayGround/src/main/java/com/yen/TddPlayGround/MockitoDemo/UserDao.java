package com.yen.TddPlayGround.MockitoDemo;

import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {
}
