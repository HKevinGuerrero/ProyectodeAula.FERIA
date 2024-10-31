package com.Aplication.Services;


import com.Aplication.modelo.Turno;
import com.Aplication.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    // Crear o actualizar un turno
    public Turno saveOrUpdate(Turno turno) {
        // Verificar si ya existe un turno para el mismo barbero, fecha y hora
        Optional<Turno> turnoExistente = turnoRepository.findByBarberoAndFechaAndHora(
             turno.getBarbero(), turno.getFecha(), turno.getHora()
        );

        if (turnoExistente.isPresent()) {
            throw new RuntimeException("Este turno ya está reservado para esta fecha y hora con este barbero");
        }

        return turnoRepository.save(turno);
    }

    // Obtener todos los turnos
    public List<Turno> getAllTurnos() {
        return turnoRepository.findAll();
    }

    // Obtener turno por ID
    public Optional<Turno> findById(Long id) {
        return turnoRepository.findById(id);
    }

    // Eliminar un turno
    public void deleteTurno(Turno turno) {
        turnoRepository.delete(turno);
    }

    // Actualizar un turno por ID
    public Turno updateTurno(Long id, Turno updateTurno) {
        return turnoRepository.findById(id).map(turno -> {
            turno.setFecha(updateTurno.getFecha());
            turno.setLocal(updateTurno.getLocal());
            turno.setEstado(updateTurno.getEstado());
            turno.setCorte(updateTurno.getCorte());
            turno.setAdicional(updateTurno.getAdicional());
            turno.setEmailBarbero(updateTurno.getEmailBarbero());
            turno.setEmailCliente(updateTurno.getEmailCliente());
            turno.setCliente(updateTurno.getCliente());
            turno.setHora(updateTurno.getHora());
            return turnoRepository.save(turno);  // Guardar turno actualizado
        }).orElseThrow(() -> new RuntimeException("Turno no encontrado"));
    }
}
