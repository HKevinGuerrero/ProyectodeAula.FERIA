/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Aplication.controller;

import com.Aplication.Services.UserBarberoService;
import com.Aplication.modelo.UserBarbero;
import com.Aplication.modelo.UserCliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KEVIN-PC
 */

@RestController
@RequestMapping("/api/user/barbero")
@CrossOrigin(origins = "http://localhost:3000")
public class UserBarberoController {
    
    @Autowired
    private UserBarberoService userService;

    //@Autowired
    //private PasswordEncoder passwordEncoder;
    @PostMapping("/post")
    public ResponseEntity<?> create(@RequestBody UserBarbero user) {
        try {
            UserBarbero nuevoUser = userService.create(user);
            return new ResponseEntity<>(nuevoUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<List<UserBarbero>> getAllUser() {
        List<UserBarbero> user = userService.getAllUser();
        return new ResponseEntity<>(user, HttpStatus.OK);
 
    }
    
}
