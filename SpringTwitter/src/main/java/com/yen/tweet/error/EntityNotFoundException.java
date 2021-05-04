package com.yen.tweet.error;

// p.142

public class EntityNotFoundException extends Exception {

    // constructor
    public EntityNotFoundException(String message){
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
