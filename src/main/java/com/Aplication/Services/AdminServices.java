/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Aplication.Services;

import com.Aplication.modelo.Admin;
import com.Aplication.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KEVIN-PC
 */
@Service
public class AdminServices {
    @Autowired
    private AdminRepository adminRepository;

    // Método para guardar un administrador
    public Admin create(Admin admin) {
        // Guardamos el administrador en la base de datos y lo devolvemos
        return adminRepository.save(admin);
    }

    // Método para obtener todos los administradores
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Método para eliminar un administrador
    public void delete(Admin admin) {
        adminRepository.delete(admin);
    }

    // Método para encontrar administrador por nombre
    public Optional<Admin> findByNombre(String nombre) {
        return adminRepository.findByNombre(nombre);
    }

    // Método para actualizar un administrador
    public Admin updateAdmin(Long id, Admin updatedAdmin) {
        return adminRepository.findById(id).map(admin -> {
            admin.setNombre(updatedAdmin.getNombre());
            admin.setApellido(updatedAdmin.getApellido());
            admin.setTelefono(updatedAdmin.getTelefono());
            admin.setEmail(updatedAdmin.getEmail());
            admin.setRol(updatedAdmin.getRol());
            return adminRepository.save(admin); // Guardar administrador actualizado
        }).orElseThrow(() -> new RuntimeException("Administrador no encontrado"));
    }
}
