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
    private static TurnoRepository turnoRepository;

    // Crear o actualizar un turno
    public static Turno saveOrUpdate(Turno turno) {
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
