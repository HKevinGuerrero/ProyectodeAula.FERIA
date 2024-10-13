package com.Aplication.controller;

import com.Aplication.Services.ServicioService;
import com.Aplication.modelo.Reserva;
import com.Aplication.modelo.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/service")
@CrossOrigin(origins = "http://localhost:3000") // Permitir solicitudes desde este origen

public class ServicioController {


    private final ServicioService servicioservice;

    @Autowired
    public ServicioController(com.Aplication.Services.ServicioService servicioservice) {
        this.servicioservice = servicioservice;
    }

    // Crear o actualizar una Reserva
    @PostMapping("/post")
    public ResponseEntity<Servicio> createServicio(@RequestBody Servicio servicio) {
        Servicio nuevaServicio = ServicioService.saveOrUpdate(servicio);
        return new ResponseEntity<>(nuevaServicio, HttpStatus.CREATED);
    }

    // Obtener todas las Reservas
    @GetMapping
    public ResponseEntity<List<Servicio>> getAllServicio() {
        List<Servicio> servicio = servicioservice.getAllservicioRepository();
        return new ResponseEntity<>(servicio, HttpStatus.OK);
    }

    // Obtener Reserva por ID
    @GetMapping("/{id}")
    public ResponseEntity<Servicio> getServicioById(@PathVariable int id) {
        return (ResponseEntity<Servicio>) servicioservice.findById(id)
                .map(Servicio -> new ResponseEntity<>(Servicio, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Eliminar Reserva por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicio(@PathVariable int id) {
        return servicioservice.findById(id)
                .map(service -> {
                    Servicio servicio = null;
                    servicioservice.deleteServicio(servicio);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar una Reserva
    @PutMapping("/{id}")
    public ResponseEntity<Servicio> updateServicio(@PathVariable int id, @RequestBody Servicio servicio) {
        return servicioservice.findById(id)
                .map(existingServicio -> {
                    servicio.setIdservicio(existingServicio.getIdservicio());
                    Servicio updateServicio = servicioservice.saveOrUpdate(servicio);
                    return new ResponseEntity<>(updateServicio, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
