package com.springboot.controller;

import com.springboot.model.User;
import com.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User u = userService.saveUser(user);
        if(u == null)
            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("id") long id) {
        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
