package com.fit.se.controller;

import com.fit.se.entity.User;
import com.fit.se.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<User> userList = userService.getAllUser();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") int userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") int userId) {
        userService.deleteUserById(userId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable("id") int userId, @RequestBody User newUser) {
       User user = userService.updateUserById(userId, newUser);
       return ResponseEntity.ok(user);
    }
}
