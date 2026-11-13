package com.java14.Jpa2.controller;

import com.java14.Jpa2.entity.UserEntity;
import com.java14.Jpa2.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseEntity<?> addUser(@Valid @RequestBody UserEntity user) {
        return ResponseEntity.ok(userServices.addUser(user));
    }
}
