package com.Aplication.modelodto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Turnerodto {

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
     * @return the barberia
     */
    public String getBarberia() {
        return barberia;
    }

    /**
     * @param barberia the barberia to set
     */
    public void setBarberia(String barberia) {
        this.barberia = barberia;
    }

    /**
     * @return the numeroturno
     */
    public String getNumeroturno() {
        return numeroturno;
    }

    /**
     * @param numeroturno the numeroturno to set
     */
    public void setNumeroturno(String numeroturno) {
        this.numeroturno = numeroturno;
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
    
    private Long id;

    private String barberia;

    private String numeroturno;
    
    private String hora;

    private LocalDate fecha;
}
