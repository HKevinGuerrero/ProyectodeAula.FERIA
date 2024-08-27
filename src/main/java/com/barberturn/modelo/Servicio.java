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
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idservicio;
    
    @Column(name = "nombreservicio", nullable = false, columnDefinition = "String")
    private String nombreservicio;
    
    @Column(name = "decripcionservicio", nullable = false, columnDefinition = "String")
    private String decripcionservicio;
    
    @Column(name = "precioservicio", nullable = false, columnDefinition = "long")
    private long precioservicio;
}
