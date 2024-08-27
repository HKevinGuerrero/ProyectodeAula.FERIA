/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.barberturn.Baber.turn.Services;

import com.barberturn.modelo.dto.Clientedto;
import com.barberturn.modelo.dto.Empleadto;
import com.barberturn.modelo.repository.EmpleadoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */

@Service
public class EmpleadoServices {
    EmpleadoRepository empleadoRepository;
    
    public List<Empleadto> getAllEmpleado() {
        return empleadoRepository.findAll().stream()
                .map(Empleado->{
                return new Empleadto(Empleado.getIdempleado(), Empleado.getEmple_nombre(), Empleado.getEmple_apellido(), Empleado.getEmple_telefono(), Empleado.getEmple_email(), Empleado.getEmple_puesto());
                }).toList();
    }
}


