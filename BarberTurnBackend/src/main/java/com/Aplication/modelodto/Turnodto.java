
package com.Aplication.modelodto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor

public class Turnodto {

    /**
     * @return the fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

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
     * @return the barbero
     */
    public String getBarbero() {
        return barbero;
    }

    /**
     * @param barbero the barbero to set
     */
    public void setBarbero(String barbero) {
        this.barbero = barbero;
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
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the corte
     */
    public String getCorte() {
        return corte;
    }

    /**
     * @param corte the corte to set
     */
    public void setCorte(String corte) {
        this.corte = corte;
    }

    /**
     * @return the adicional
     */
    public String getAdicional() {
        return adicional;
    }

    /**
     * @param adicional the adicional to set
     */
    public void setAdicional(String adicional) {
        this.adicional = adicional;
    }

    /**
     * @return the emailBarbero
     */
    public String getEmailBarbero() {
        return emailBarbero;
    }

    /**
     * @param emailBarbero the emailBarbero to set
     */
    public void setEmailBarbero(String emailBarbero) {
        this.emailBarbero = emailBarbero;
    }

    /**
     * @return the emailCliente
     */
    public String getEmailCliente() {
        return emailCliente;
    }

    /**
     * @param emailCliente the emailCliente to set
     */
    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    private Long id;
    
    private String barbero;//cambiado
    
    private String local;

    private LocalDate fecha;

    private String estado;
    
    private String corte;
    
    private String adicional;
    
    private String emailBarbero;
    
    private String emailCliente;
    
    private String cliente;
    
    private String hora;

}