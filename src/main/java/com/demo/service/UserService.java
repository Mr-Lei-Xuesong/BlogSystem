package com.demo.service;

import com.demo.entity.User;

public interface UserService {

    User checkUser(String username, String password);
}
