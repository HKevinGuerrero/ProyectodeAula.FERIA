/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.barberturn.modelo.dto;

/**
 *
 * @author USUARIO
 */
public class Empleadto {
    

    private int idempleado;

    private String Emple_nombre;

    private String Emple_apellido;

    private Long Emple_telefono;

    private String Emple_email;

    private String Emple_puesto;

    public Empleadto() {
    }

    public Empleadto(int idempleado, String Emple_nombre, String Emple_apellido, Long Emple_telefono, String Emple_email, String Emple_puesto) {
        this.idempleado = idempleado;
        this.Emple_nombre = Emple_nombre;
        this.Emple_apellido = Emple_apellido;
        this.Emple_telefono = Emple_telefono;
        this.Emple_email = Emple_email;
        this.Emple_puesto = Emple_puesto;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getEmple_nombre() {
        return Emple_nombre;
    }

    public void setEmple_nombre(String Emple_nombre) {
        this.Emple_nombre = Emple_nombre;
    }

    public String getEmple_apellido() {
        return Emple_apellido;
    }

    public void setEmple_apellido(String Emple_apellido) {
        this.Emple_apellido = Emple_apellido;
    }

    public Long getEmple_telefono() {
        return Emple_telefono;
    }

    public void setEmple_telefono(Long Emple_telefono) {
        this.Emple_telefono = Emple_telefono;
    }

    public String getEmple_email() {
        return Emple_email;
    }

    public void setEmple_email(String Emple_email) {
        this.Emple_email = Emple_email;
    }

    public String getEmple_puesto() {
        return Emple_puesto;
    }

    public void setEmple_puesto(String Emple_puesto) {
        this.Emple_puesto = Emple_puesto;
    }
     
    
}
