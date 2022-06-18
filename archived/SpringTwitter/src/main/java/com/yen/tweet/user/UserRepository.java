package com.yen.tweet.user;

// p.136, p.137 p.143

import com.yen.tweet.error.EntityNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Repository
public class UserRepository {

    // constructor
    public UserRepository(){
    }

    public UserRepository(String email, User user){
    }

    // User is from com.yen.tweet.user
    private final Map<String, User> userMap = new ConcurrentHashMap<>();

    public User update(String email, User user) throws
      EntityNotFoundException{
        if (!exists(email)){
            throw new EntityNotFoundException("User " + email + " can not be found");
        }
        user.setEmail(email);
        return userMap.put(email, user);
    }

    public User save(User user){
        return userMap.put(user.getEmail(), user);
    }

    public User findOne(String email) throws EntityNotFoundException {
        if (!exists(email)){
            throw new EntityNotFoundException("User " + email + " can not be found");
        }
        return userMap.get(email);
    }

    public List<User> findALL(){
        return new ArrayList<>(userMap.values());
    }

    public void delete(String email) throws EntityNotFoundException {
        if (!exists(email)){
            throw new EntityNotFoundException("User " + email + " can not be found");
        }
        userMap.remove(email);
    }

    public boolean exists(String email){
        return userMap.containsKey(email);
    }
}
