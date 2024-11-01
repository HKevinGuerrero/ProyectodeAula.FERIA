package com.Aplication.controller;

import com.Aplication.Services.AdminServices;
import com.Aplication.Services.BarberoService;
import com.Aplication.Services.ClienteServices;
import com.Aplication.Services.UserClienteService;
import com.Aplication.modelo.Admin;
import com.Aplication.modelo.Barbero;
import com.Aplication.modelo.Cliente;
import com.Aplication.modelo.UserCliente;
import com.Aplication.modelodto.UserClienteDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/cliente")
@CrossOrigin(origins = "http://localhost:3000")
public class UserClienteController {

    @Autowired
    private UserClienteService userService;

    //@Autowired
    //private PasswordEncoder passwordEncoder;
    @PostMapping("/post")
    public ResponseEntity<?> create(@RequestBody UserCliente user) {
        try {
            UserCliente nuevoUser = userService.create(user);
            return new ResponseEntity<>(nuevoUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    public ResponseEntity<List<UserCliente>> getAllUser() {
        List<UserCliente> user = userService.getAllUser();
        return new ResponseEntity<>(user, HttpStatus.OK);
 
    }
}