package com.stefanp.springboot.service;

import com.stefanp.springboot.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUser(long id);
    User updateUser(User user, long id);
    void deleteUser(long id);
}
