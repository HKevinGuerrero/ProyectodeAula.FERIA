/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Aplication.repository;

import com.Aplication.modelo.Barbero;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author KEVIN-PC
 */
public interface BarberoRepository extends JpaRepository<Barbero, Long> {

    public Optional<Barbero> findByNombre(String nombre);
    
}
