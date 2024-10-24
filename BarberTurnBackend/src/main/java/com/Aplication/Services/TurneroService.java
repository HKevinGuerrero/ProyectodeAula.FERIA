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
<<<<<<< HEAD
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
=======
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
>>>>>>> 2e897c28f19eb8697dc5e543bb11816e5242e030
    }

    // Eliminar un turno de servicio
    public void deleteTurnoservicio(Turnero turnoservicio) {
<<<<<<< HEAD
        turnerorepository.delete(turnoservicio);
=======
        turnoservicioRepository.delete(turnoservicio);
>>>>>>> 2e897c28f19eb8697dc5e543bb11816e5242e030
    }

    // Actualizar un turno de servicio por ID
    public Turnero updateTurnoservicio(Long id, Turnero updateTurnoservicio) {
<<<<<<< HEAD
        return turnerorepository.findById(id).map(turnoservicio -> {
=======
        return turnoservicioRepository.findById(id).map(turnoservicio -> {
>>>>>>> 2e897c28f19eb8697dc5e543bb11816e5242e030
            turnoservicio.setNumeroturno(updateTurnoservicio.getNumeroturno());
            turnoservicio.setBarberia(updateTurnoservicio.getBarberia());
            turnoservicio.setHora(updateTurnoservicio.getHora());
            turnoservicio.setFecha(updateTurnoservicio.getFecha());
<<<<<<< HEAD
            return turnerorepository.save(turnoservicio);  // Guardar turno actualizado
        }).orElseThrow(() -> new RuntimeException("Turno de servicio no encontrado"));
    }
}
=======
            return turnoservicioRepository.save(turnoservicio);  // Guardar turno actualizado
        }).orElseThrow(() -> new RuntimeException("Turno de servicio no encontrado"));
    }


}



>>>>>>> 2e897c28f19eb8697dc5e543bb11816e5242e030
