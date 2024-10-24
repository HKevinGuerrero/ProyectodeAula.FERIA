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
@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    private String nombreRegistro;
    
    private String apellidoRegistro;
    
    @Column(unique=true)
    private Long telefonoRegistro;
    
     @Column(unique=true)
    private String correo;
    
    private String rol;
    
    private String local;
    
    private String direccionRegistro;
    
    private String contrasena;
    
}
