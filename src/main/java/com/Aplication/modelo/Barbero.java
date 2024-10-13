/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Aplication.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author KEVIN-PC
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Barbero")
public class Barbero {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia de generación del ID
    private Long id;
    
    private String nombre;
    private String apellido;
    
    @Column(unique=true)
    private Long telefono;
    @Column(unique=true)
    private String email;
    
    private String local;
    private String Rol;
}
