package com.Aplication.Services;

import com.Aplication.modelo.Admin;
import com.Aplication.modelo.UserCliente;
import com.Aplication.modelodto.UserClienteDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Aplication.repository.UserClienteRepository;

@Service
public class UserClienteService {
     
    @Autowired
    private UserClienteRepository userRepository;
    
    // Método para guardar un cliente
    public UserCliente create(UserCliente user) {
        // Guardamos el cliente en la base de datos y lo devolvemos
        return userRepository.save(user);
    }

    // Lista
    public List<UserCliente> getAllUser() {
        return userRepository.findAll();
    }

    public void delete(UserCliente user) {
        userRepository.delete(user);
    }

    public Optional<UserCliente> findBynombre(String nombre) {
        return userRepository.findByUsername(nombre);
    }

    
    
    
}
