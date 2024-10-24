package com.Aplication.modelodto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor

public class Localdto {

    /**
     * @return the idlocal
     */
    public Long getIdlocal() {
        return idlocal;
    }

    /**
     * @param idlocal the idlocal to set
     */
    public void setIdlocal(Long idlocal) {
        this.idlocal = idlocal;
    }

    /**
     * @return the localRegistro
     */
    public String getLocalRegistro() {
        return localRegistro;
    }

    /**
     * @param localRegistro the localRegistro to set
     */
    public void setLocalRegistro(String localRegistro) {
        this.localRegistro = localRegistro;
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

    /**
     * @return the telefonoRegistro
     */
    public long getTelefonoRegistro() {
        return telefonoRegistro;
    }

    /**
     * @param telefonoRegistro the telefonoRegistro to set
     */
    public void setTelefonoRegistro(long telefonoRegistro) {
        this.telefonoRegistro = telefonoRegistro;
    }
    
    private Long idlocal;

    private String localRegistro;
    private String direccionRegistro;

    private Long telefonoRegistro;


}