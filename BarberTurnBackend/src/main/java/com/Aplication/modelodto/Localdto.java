package com.Aplication.modelodto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor

public class Localdto {
    @Id
    private int idlocal;

    private String nombre;
    private String dirrecion;

    private long telefono;


}