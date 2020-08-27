package com.example.casestudy.controller;

import com.example.casestudy.model.User;
import com.example.casestudy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User product) {
        product.setUserId(id);
        return new ResponseEntity<>(userService.saveUser(product), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<User>> findAll() {
        return new ResponseEntity<>(userService.findAllUser(), HttpStatus.OK);
    }

    @GetMapping("findUserById/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping("findUserByEmail/{email}")
    public ResponseEntity<User> findByName(@PathVariable String email) {
        return new ResponseEntity<>(userService.findUserByEmail(email), HttpStatus.OK);
    }

    @GetMapping("findUserByName/{name}")
    public ResponseEntity<Iterable<User>> findByNameContains(@PathVariable String name) {
        return new ResponseEntity<>(userService.findUserByName(name), HttpStatus.OK);
    }
}