package com.demo.controller;

import com.demo.entity.UserDetails;
import com.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDetails> createUser(@RequestBody UserDetails userDetails) {
        return new ResponseEntity<>(userService.createUser(userDetails), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDetails>> getAllTheUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetails> getById(@PathVariable int id) {
        UserDetails user = userService.getById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetails> updateUser(@PathVariable int id, @RequestBody UserDetails userDetails) {
        UserDetails updatedUser = userService.updateById(id, userDetails);
        if (updatedUser!=null) {
            return new ResponseEntity<>(updatedUser,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        UserDetails user = userService.getById(id);
        if (user!=null) {
            userService.deleteById(id);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
}
