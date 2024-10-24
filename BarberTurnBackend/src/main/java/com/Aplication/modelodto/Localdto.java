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

    
    
    private Long idlocal;

    private String local;
    private String direccionRegistro;

    private Long telefonoRegistro;


}