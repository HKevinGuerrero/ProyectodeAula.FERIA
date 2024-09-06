/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.barberturn.Baber.turn.Services;

import com.barberturn.modelo.Cliente;
import com.barberturn.modelo.dto.Clientedto;
import com.barberturn.modelo.repository.ClienteRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service

public class ClienteServices {
    ClienteRepository clienteRepository;

    public List<Clientedto> getAllClientes() {
        return clienteRepository.findAll().stream()
                .map(cliente->{
                return new Clientedto(cliente.getId(), cliente.getNombre(), cliente.getApellido(), cliente.getTelefono(), cliente.getEmail());
                }).toList();
        
    }
}
