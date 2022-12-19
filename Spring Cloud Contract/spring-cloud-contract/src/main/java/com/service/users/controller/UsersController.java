package com.service.users.controller;

import com.service.users.entity.Users;
import com.service.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService service;

    @PostMapping
    public ResponseEntity<Users> saveUser(@RequestBody Users request){
        Users users = service.saveUser(request);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Users> getAll(){
        return service.findAllUsers();
    }

}
