/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.barberturn.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Reserva")
public class Reserva {
    
    @Id
    private Long id;
    
    @ManyToOne
    private Empleado empleado;
    
    @ManyToOne
    private Cliente cliente;
    
    private String reservalocal;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime reservafecha;

    @Column(name = "estado")
    private String reservaestado;
}
