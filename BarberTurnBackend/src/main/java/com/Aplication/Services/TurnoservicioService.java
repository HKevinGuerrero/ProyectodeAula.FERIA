package com.Aplication.Services;

import com.Aplication.modelo.Cliente;
import com.Aplication.modelo.Turnoservicio;
import com.Aplication.repository.TurnoServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoservicioService {

    @Autowired
    private static TurnoServicioRepository turnoservicioRepository;

    public static List<TurnoservicioService> getAllTurnoservicioService() {
        return List.of();
    }

    // Crear o actualizar un turno de servicio
    public Turnoservicio saveOrUpdate(Turnoservicio turnoservicio) {
        return null;
    }

    // Obtener todos los turnos de servicio
    public List<Turnoservicio> getAllTurnoservicios() {
        return turnoservicioRepository.findAll();
    }

    // Obtener turno de servicio por ID
    public static Optional<Turnoservicio> findById(Long id) {
        return turnoservicioRepository.findById(id);
    }

    // Eliminar un turno de servicio
    public void deleteTurnoservicio(Turnoservicio turnoservicio) {
        turnoservicioRepository.delete(turnoservicio);
    }

    // Actualizar un turno de servicio por ID
    public Turnoservicio updateTurnoservicio(Long id, Turnoservicio updateTurnoservicio) {
        return turnoservicioRepository.findById(id).map(turnoservicio -> {
            turnoservicio.setTurno(updateTurnoservicio.getTurno());
            turnoservicio.setServicio(updateTurnoservicio.getServicio());
            return turnoservicioRepository.save(turnoservicio);  // Guardar turno actualizado
        }).orElseThrow(() -> new RuntimeException("Turno de servicio no encontrado"));
    }


}



