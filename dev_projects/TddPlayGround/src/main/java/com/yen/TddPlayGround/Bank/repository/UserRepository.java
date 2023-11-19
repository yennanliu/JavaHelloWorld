package com.yen.TddPlayGround.Bank.repository;

import com.yen.TddPlayGround.Bank.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

// https://openhome.cc/Gossip/Spring/SpringDataJDBC.html#:~:text=%E9%A1%A7%E5%90%8D%E6%80%9D%E7%BE%A9%EF%BC%8C%20CrudRepository%20%E9%80%99%E5%80%8B%E4%BB%8B%E9%9D%A2%EF%BC%8C%E5%AE%9A%E7%BE%A9,%E5%A4%A7%E5%90%8C%E5%B0%8F%E7%95%B0%EF%BC%8C%E7%95%A2%E7%AB%9F%E6%98%AF%E5%9F%BA%E6%96%BCSpring
// https://blog.csdn.net/qq_31635851/article/details/120884850

// TODO : check difference between CrudRepository VS JpaRepository
public interface UserRepository extends JpaRepository<User, String> {
}
