/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Aplication.controller;

import com.Aplication.Services.AdminServices;
import com.Aplication.modelo.Admin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KEVIN-PC
 */

@RestController
@RequestMapping("/api/adminbarberia")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
    @Autowired
    private AdminServices adminServices;

    @PostMapping("/post")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin nuevoAdmin = adminServices.create(admin);
        return new ResponseEntity<>(nuevoAdmin, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminServices.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Admin> getAdminByNombre(@PathVariable String nombreRegistro) {
        return adminServices.findByNombreRegistro(nombreRegistro)
                .map(admin -> new ResponseEntity<>(admin, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable String nombreRegistro) {
        return adminServices.findByNombreRegistro(nombreRegistro) // Buscar el administrador por nombre
                .map(admin -> {
                    adminServices.delete(admin); // Eliminar administrador si existe
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // Respuesta 204 si se elimina correctamente
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Respuesta 404 si no se encuentra el administrador
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin updatedAdmin) {
        try {
            Admin adminActualizado = adminServices.updateAdmin(id, updatedAdmin);
            return new ResponseEntity<>(adminActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

