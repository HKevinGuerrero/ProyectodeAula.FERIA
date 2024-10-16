package com.Aplication.Services;

import com.Aplication.modelo.Servicio;
import com.Aplication.repository.ServicioRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioService {


    @Autowired
    private ServicioRepository servicioRepository;

    public static Servicio saveOrUpdate(Servicio servicio) {
        return servicio;
    }

    // Crear o actualizar un servicio

    // Obtener todos los empleados
    public List<Servicio> getAllservicioRepository() {
        return servicioRepository.findAll();
    }

    // Obtener servicio por ID
    public Optional<Servicio> findById(int id) {
        return servicioRepository.findById((long) id);
    }

    // Eliminar un servicio por su ID
    public void deleteServicio(Servicio servicio) {
        servicioRepository.delete(servicio);
    }

    public Servicio updateturno(Long id, Servicio updateservicio) {
        return servicioRepository.findById(id).map(servicio -> {
            servicio.setIdservicio(updateservicio.getIdservicio());
            servicio.setNombreservicio(updateservicio.getNombreservicio());
            servicio.setDecripcionservicio(updateservicio.getDecripcionservicio());
            servicio.setPrecioservicio(updateservicio.getPrecioservicio());
            return servicioRepository.save(servicio); // Guardar servicio actualizado
        }).orElseThrow(() -> new RuntimeException("Local no encontrado"));
    }
}
