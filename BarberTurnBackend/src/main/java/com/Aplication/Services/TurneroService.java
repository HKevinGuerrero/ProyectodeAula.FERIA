package com.Aplication.Services;

import com.Aplication.modelo.Cliente;
import com.Aplication.modelo.Turnero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.Aplication.repository.TurneroRepository;

@Service
public class TurneroService {

    @Autowired
    private TurneroRepository turnerorepository; 

    // Obtener todos los turnos de servicio
    public List<Turnero> getAllTurnoservicios() {
        return turnerorepository.findAll();
    }

    // Crear o actualizar un turno de servicio
    public Turnero saveOrUpdate(Turnero turnero) {
        return turnerorepository.save(turnero);
    }

    // Obtener turno de servicio por ID
    public Optional<Turnero> findById(Long id) {  // No debe ser static
        return turnerorepository.findById(id);
    }

    // Eliminar un turno de servicio
    public void deleteTurnoservicio(Turnero turnoservicio) {
        turnerorepository.delete(turnoservicio);
    }

    // Actualizar un turno de servicio por ID
    public Turnero updateTurnoservicio(Long id, Turnero updateTurnoservicio) {
        return turnerorepository.findById(id).map(turnoservicio -> {
            turnoservicio.setNumeroturno(updateTurnoservicio.getNumeroturno());
            turnoservicio.setBarberia(updateTurnoservicio.getBarberia());
            turnoservicio.setHora(updateTurnoservicio.getHora());
            turnoservicio.setFecha(updateTurnoservicio.getFecha());
            return turnerorepository.save(turnoservicio);  // Guardar turno actualizado
        }).orElseThrow(() -> new RuntimeException("Turno de servicio no encontrado"));
    }
}