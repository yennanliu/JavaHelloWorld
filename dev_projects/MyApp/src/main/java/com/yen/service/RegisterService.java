package com.yen.service;

public interface RegisterService {

    Boolean isExisted(String address);
    Boolean register(String address);

    Boolean validate(String address);

}
