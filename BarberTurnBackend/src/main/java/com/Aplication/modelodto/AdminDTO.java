/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Aplication.modelodto;

/**
 *
 * @author KEVIN-PC
 */
public class AdminDTO {

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nombreResgistro
     */
    public String getNombreResgistro() {
        return nombreResgistro;
    }

    /**
     * @param nombreResgistro the nombreResgistro to set
     */
    public void setNombreResgistro(String nombreResgistro) {
        this.nombreResgistro = nombreResgistro;
    }

    /**
     * @return the apellidoResgistro
     */
    public String getApellidoResgistro() {
        return apellidoResgistro;
    }

    /**
     * @param apellidoResgistro the apellidoResgistro to set
     */
    public void setApellidoResgistro(String apellidoResgistro) {
        this.apellidoResgistro = apellidoResgistro;
    }

    /**
     * @return the telefonoRegistro
     */
    public Long getTelefonoRegistro() {
        return telefonoRegistro;
    }

    /**
     * @param telefonoRegistro the telefonoRegistro to set
     */
    public void setTelefonoRegistro(Long telefonoRegistro) {
        this.telefonoRegistro = telefonoRegistro;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the direccionRegistro
     */
    public String getDireccionRegistro() {
        return direccionRegistro;
    }

    /**
     * @param direccionRegistro the direccionRegistro to set
     */
    public void setDireccionRegistro(String direccionRegistro) {
        this.direccionRegistro = direccionRegistro;
    }
 
    private Long id;
    private String nombreResgistro;
    private String apellidoResgistro;
    private Long telefonoRegistro;
    private String correo;
    private String rol;
    private String local;
    private String direccionRegistro;
    
}
