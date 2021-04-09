package com.yen.tweet.user;

// p.136, p.137

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    // User is from com.yen.tweet.user
    private final Map<String, User> userMap = new ConcurrentHashMap<>();

    public User save(String email, User user){
        user.setEmail(email);
        return userMap.put(email, user);
    }

    public User save(User user){
        return save(user.getEmail(), user);
    }

    public User findOne(String email){
        return userMap.get(email);
    }

    public List<User> findALL(){
        return new ArrayList<>(userMap.values());
    }

    public void delete(String email){
        userMap.remove(email);
    }

    public boolean exists(String email){
        return userMap.containsKey(email);
    }
}
