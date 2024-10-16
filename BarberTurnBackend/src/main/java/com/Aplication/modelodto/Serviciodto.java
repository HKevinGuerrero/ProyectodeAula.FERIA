package com.Aplication.modelodto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Serviciodto {


    private int idservicio;

    private String nombreservicio;

    private String decripcionservicio;

    private long precioservicio;
}
