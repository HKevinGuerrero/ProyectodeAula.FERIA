/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Aplication.repository;

import com.Aplication.modelo.Turnero;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TurneroRepository extends JpaRepository<Turnero, Long> {
    
    Optional<Turnero> findByBarberiaAndFechaAndHora(String barberia, LocalDate fecha, String hora);

}
