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
public class Local {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idlocal;

@Column(name = "nombrelocal", nullable = false, columnDefinition = "String")
    private String nombrelocal;
@Column(name = "dirrecionlocal", nullable = false, columnDefinition = "String")
    private String dirrecionlocal;

@Column(name = "telefonolocal", nullable = false, columnDefinition = "long")
   private long telefonolocal;
    
    
}
