package com.Aplication.controller;

import com.Aplication.Services.TurneroService;
import com.Aplication.modelo.Turnero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turnero")
@CrossOrigin(origins = "http://localhost:3000")
public class TurneroController {

    @Autowired
    private TurneroService turnoservicioService;

    // Crear un nuevo Turnero
    @PostMapping("/post")
    public ResponseEntity<?> createTurnoServicio(@RequestBody Turnero turnoServicio) {
        try {
            Turnero nuevoTurnoservicio = turnoservicioService.saveOrUpdate(turnoServicio);
            return new ResponseEntity<>(nuevoTurnoservicio, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Turno ya reservado para esta fecha y hora en esta barbería", HttpStatus.CONFLICT);
        }
    }

    // Obtener todos los turneros de servicio
    @GetMapping
    public ResponseEntity<List<Turnero>> getAllTurnoservicios() {
        List<Turnero> turnoservicios = turnoservicioService.getAllTurnoservicios();
        return new ResponseEntity<>(turnoservicios, HttpStatus.OK);
    }

    // Obtener turnero por ID
    @GetMapping("/{id}")
    public ResponseEntity<Turnero> getTurnoServicioById(@PathVariable Long id) {
        Optional<Turnero> turnoServicio = turnoservicioService.findById(id);
        return turnoServicio.map(ts -> new ResponseEntity<>(ts, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar un turnero por ID
    @PutMapping("/{id}")
    public ResponseEntity<Turnero> updateTurnoServicio(@PathVariable Long id, @RequestBody Turnero updatedTurnoServicio) {
        try {
            Turnero turnoServicioActualizado = turnoservicioService.updateTurnoservicio(id, updatedTurnoServicio);
            return new ResponseEntity<>(turnoServicioActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un turnero por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurnoServicio(@PathVariable Long id) {
        Optional<Turnero> turnoServicio = turnoservicioService.findById(id);
        if (turnoServicio.isPresent()) {
            turnoservicioService.deleteTurnoservicio(turnoServicio.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
