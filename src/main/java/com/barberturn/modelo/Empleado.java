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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Empleado {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idempleado; 

@Column(name = "Emple_nombre", nullable = false, columnDefinition = "String")
    private String Emple_nombre;

@Column(name = "Emple_apellido", nullable = false, columnDefinition = "String")
    private String Emple_apellido;

@Column(name = "Emple_telefono", columnDefinition = "long")
    private Long Emple_telefono;
    
@Column(name = "Emple_email", columnDefinition = "String")

    private String Emple_email;

@Column(name = "Emple_puesto", columnDefinition = "String")
    private String Emple_puesto;


        
    
}
