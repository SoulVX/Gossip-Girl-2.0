package com.stefanp.springboot.service.impl;

import com.stefanp.springboot.model.User;
import com.stefanp.springboot.repository.UserRepository;
import com.stefanp.springboot.service.UserService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        User u = null;
        try {
            u = this.userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            System.out.println("Error: Username already exists!");
        }
        return u;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User updateUser(User user, long id) {
        User existentUser = getUser(id);
        if(user.getUsername() != null)
            existentUser.setUsername(user.getUsername());
        if(user.getPassword() != null)
            existentUser.setPassword(user.getPassword());
        if(user.getIsMuted() != null)
            existentUser.setIsMuted(user.getIsMuted());
        userRepository.save(existentUser);
        return existentUser;
    }

    @Override
    public void deleteUser(long id) {
        getUser(id);
        userRepository.deleteById(id);
    }
}
