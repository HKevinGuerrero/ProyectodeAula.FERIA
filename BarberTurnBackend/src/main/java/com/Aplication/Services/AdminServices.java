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
    public Optional<Admin> findByNombreRegistro(String nombreRegistro) {
        return adminRepository.findByNombreRegistro(nombreRegistro);
    }


    // Método para actualizar un administrador
    public Admin updateAdmin(Long id, Admin updatedAdmin) {
        return adminRepository.findById(id).map(admin -> {
            admin.setNombreRegistro(updatedAdmin.getNombreRegistro());
            admin.setApellidoRegistro(updatedAdmin.getApellidoRegistro());
            admin.setTelefonoRegistro(updatedAdmin.getTelefonoRegistro());
            admin.setCorreo(updatedAdmin.getCorreo());
            admin.setRol(updatedAdmin.getRol());
            admin.setLocal(updatedAdmin.getLocal());
            admin.setContrasena(updatedAdmin.getContrasena());
            return adminRepository.save(admin); // Guardar administrador actualizado
        }).orElseThrow(() -> new RuntimeException("Administrador no encontrado"));
    }
}
