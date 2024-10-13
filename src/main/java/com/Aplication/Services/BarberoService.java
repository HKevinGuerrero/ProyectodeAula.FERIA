/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Aplication.Services;

import com.Aplication.modelo.Barbero;
import com.Aplication.modelodto.BarberoDTO;
import com.Aplication.repository.BarberoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KEVIN-PC
 */
@Service
public class BarberoService {
    
    @Autowired
    private BarberoRepository barberoRepository;

    // Método para guardar un barbero
    public Barbero create(Barbero barbero) {
        // Guardamos el barbero en la base de datos y lo devolvemos
        return barberoRepository.save(barbero);
    }

    // Método para obtener todos los barberos
    public List<Barbero> getAllBarberos() {
        return barberoRepository.findAll();
    }

    // Método para eliminar un barbero
    public void delete(Barbero barbero) {
        barberoRepository.delete(barbero);
    }

    // Método para encontrar barbero por nombre
    public Optional<Barbero> findByNombre(String nombre) {
        return barberoRepository.findByNombre(nombre);
    }

    // Método para actualizar un barbero
    public Barbero updateBarbero(Long id, Barbero updatedBarbero) {
        return barberoRepository.findById(id).map(barbero -> {
            barbero.setNombre(updatedBarbero.getNombre());
            barbero.setApellido(updatedBarbero.getApellido());
            barbero.setTelefono(updatedBarbero.getTelefono());
            barbero.setEmail(updatedBarbero.getEmail());
            barbero.setLocal(updatedBarbero.getLocal());
            barbero.setRol(updatedBarbero.getRol());
            return barberoRepository.save(barbero); // Guardar barbero actualizado
        }).orElseThrow(() -> new RuntimeException("Barbero no encontrado"));
    }
}
