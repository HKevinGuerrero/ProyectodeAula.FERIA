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
    
    @Autowired
    private UserBarberoService userBarberoService;
    
    // Método para guardar un cliente
    public UserCliente create(UserCliente user) {
        // Verificamos que el usuario no exista en ninguna de las dos tablas
        if (userRepository.findByUsername(user.getUsername()).isPresent() ||
            userBarberoService.findBynombre(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("El usuario ya existe en otra tabla");
        }
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
