/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Aplication.controller;

import com.Aplication.Services.BarberoService;
import com.Aplication.modelo.Barbero;
import com.Aplication.modelodto.BarberoDTO;
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
@RequestMapping("/api/barberos")
@CrossOrigin(origins = "http://localhost:3000")
public class BarberoController {
    
    @Autowired
    private BarberoService barberoService;

    @PostMapping("/post")
    public ResponseEntity<Barbero> createBarbero(@RequestBody Barbero barbero) {
        Barbero nuevoBarbero = barberoService.create(barbero);
        return new ResponseEntity<>(nuevoBarbero, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Barbero>> getAllBarberos() {
        List<Barbero> barberos = barberoService.getAllBarberos();
        return new ResponseEntity<>(barberos, HttpStatus.OK);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Barbero> getBarberoByNombre(@PathVariable String nombre) {
        return barberoService.findByNombre(nombre)
                .map(barbero -> new ResponseEntity<>(barbero, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> deleteBarbero(@PathVariable String nombre) {
        return barberoService.findByNombre(nombre) // Buscar el barbero por nombre
                .map(barbero -> {
                    barberoService.delete(barbero); // Eliminar barbero si existe
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // Respuesta 204 si se elimina correctamente
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Respuesta 404 si no se encuentra el barbero
    }

    @PutMapping("/{id}")
    public ResponseEntity<Barbero> updateBarbero(@PathVariable Long id, @RequestBody Barbero updatedBarbero) {
        try {
            Barbero barberoActualizado = barberoService.updateBarbero(id, updatedBarbero);
            return new ResponseEntity<>(barberoActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
