package com.Aplication.controller;


import com.Aplication.Services.EmpleadoServices;

import com.Aplication.modelo.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleado")
@CrossOrigin(origins = "http://localhost:3000")
public class EmepleadoControler {

    @Autowired

    private EmpleadoServices empleadoService;

    public void EmpleadoController(EmpleadoServices empleadoService) {
        this.empleadoService = empleadoService;
    }

    // Crear o actualizar un empleado
    @PostMapping("/Post")
    public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) {
        Empleado nuevoEmpleado = empleadoService.saveOrUpdate(empleado);
        return new ResponseEntity<>(nuevoEmpleado, HttpStatus.CREATED);
    }

    // Obtener todos los empleados
    @GetMapping
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        List<Empleado> empleados = empleadoService.getAllEmpleados();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    // Obtener empleado por ID
    @GetMapping("/id")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable int id) {
        return empleadoService.findById(id)
                .map(empleado -> new ResponseEntity<>(empleado, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Eliminar empleado por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable int id) {
        return empleadoService.findById(id)
                .map(empleado -> {
                    empleadoService.deleteEmpleado(empleado);
                    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar un empleado
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable int id, @RequestBody Empleado empleado) {
        return empleadoService.findById(id)
                .map(existingEmpleado -> {
                    empleado.setIdempleado(existingEmpleado.getIdempleado());
                    Empleado updatedEmpleado = empleadoService.saveOrUpdate(empleado);
                    return new ResponseEntity<>(updatedEmpleado, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

