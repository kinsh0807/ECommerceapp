package com.aster.ecom.controller;


import com.aster.ecom.domain.Users;
import com.aster.ecom.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.Map;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/register")
    public ResponseEntity<Users> registerUser(@RequestBody Users users) {
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Users> loginUser(@RequestBody Users users) {
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/deactivate")
    public ResponseEntity<Void> deactivateUser(@RequestBody String email) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    }







