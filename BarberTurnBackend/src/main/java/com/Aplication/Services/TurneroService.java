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
    private static TurneroRepository turnoservicioRepository;

    public static List<TurneroService> getAllTurnoservicioService() {
        return List.of();
    }

    // Crear o actualizar un turno de servicio
    public Turnero saveOrUpdate(Turnero turnoservicio) {
        return null;
    }

    // Obtener todos los turnos de servicio
    public List<Turnero> getAllTurnoservicios() {
        return turnoservicioRepository.findAll();
    }

    // Obtener turno de servicio por ID
    public static Optional<Turnero> findById(Long id) {
        return turnoservicioRepository.findById(id);
    }

    // Eliminar un turno de servicio
    public void deleteTurnoservicio(Turnero turnoservicio) {
        turnoservicioRepository.delete(turnoservicio);
    }

    // Actualizar un turno de servicio por ID
    public Turnero updateTurnoservicio(Long id, Turnero updateTurnoservicio) {
        return turnoservicioRepository.findById(id).map(turnoservicio -> {
            turnoservicio.setNumeroturno(updateTurnoservicio.getNumeroturno());
            turnoservicio.setBarberia(updateTurnoservicio.getBarberia());
            turnoservicio.setHora(updateTurnoservicio.getHora());
            turnoservicio.setFecha(updateTurnoservicio.getFecha());
            return turnoservicioRepository.save(turnoservicio);  // Guardar turno actualizado
        }).orElseThrow(() -> new RuntimeException("Turno de servicio no encontrado"));
    }


}



