package com.Aplication.controller;

import com.Aplication.Services.TurnoservicioService;
import com.Aplication.modelo.Turnoservicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turnoservicio")
@CrossOrigin(origins = "http://localhost:3000")
public class TurnoServicioController {

    @Autowired
    private TurnoservicioService turnoservicioService;

    // Crear un nuevo Turno de servicio
    @PostMapping("/post")
    public ResponseEntity<Turnoservicio> createTurnoServicio(@RequestBody Turnoservicio turnoServicio) {
        Turnoservicio nuevoTurnoservicio = turnoservicioService.saveOrUpdate(turnoServicio);
        return new ResponseEntity<>(nuevoTurnoservicio, HttpStatus.CREATED);
    }

    // Obtener todos los turnos de servicio
    @GetMapping
    public ResponseEntity<List<Turnoservicio>> getAllTurnoservicios() {
        List<Turnoservicio> turnoservicios = turnoservicioService.getAllTurnoservicios();
        return new ResponseEntity<>(turnoservicios, HttpStatus.OK);
    }

    // Obtener turno de servicio por ID
    @GetMapping("/{id}")
    public ResponseEntity<Turnoservicio> getTurnoServicioById(@PathVariable Long id) {
        Optional<Turnoservicio> turnoServicio = turnoservicioService.findById(id);
        return turnoServicio.map(ts -> new ResponseEntity<>(ts, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar un turno de servicio por ID
    @PutMapping("/{id}")
    public ResponseEntity<Turnoservicio> updateTurnoServicio(@PathVariable Long id, @RequestBody Turnoservicio updatedTurnoServicio) {
        try {
            Turnoservicio turnoServicioActualizado = turnoservicioService.updateTurnoservicio(id, updatedTurnoServicio);
            return new ResponseEntity<>(turnoServicioActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un turno de servicio por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurnoServicio(@PathVariable Long id) {
        Optional<Turnoservicio> turnoServicio = turnoservicioService.findById(id);
        if (turnoServicio.isPresent()) {
            turnoservicioService.deleteTurnoservicio(turnoServicio.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
