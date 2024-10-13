/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Aplication.Services;

import com.Aplication.modelo.UserBarbero;
import com.Aplication.modelo.UserCliente;
import com.Aplication.repository.UserBarberoRepository;
import com.Aplication.repository.UserClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KEVIN-PC
 */
@Service
public class UserBarberoService {
    
    @Autowired
    private UserBarberoRepository userBarberoRepository;
    
    // Método para guardar un cliente
    public UserBarbero create(UserBarbero user) {
        // Guardamos el cliente en la base de datos y lo devolvemos
        return userBarberoRepository.save(user);
    }

    // Lista
    public List<UserBarbero> getAllUser() {
        return userBarberoRepository.findAll();
    }

    public void delete(UserBarbero user) {
        userBarberoRepository.delete(user);
    }

    public Optional<UserBarbero> findBynombre(String nombre) {
        return userBarberoRepository.findByUsername(nombre);
    }
    
}
