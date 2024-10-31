/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Aplication.repository;

import com.Aplication.modelo.Turno;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TurnoRepository extends JpaRepository<Turno, Long> {
    
     Optional<Turno> findByBarberoAndFechaAndHora(String barbero, LocalDate fecha, String hora);
}
