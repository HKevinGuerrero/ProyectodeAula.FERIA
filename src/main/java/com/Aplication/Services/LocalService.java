package com.Aplication.Services;

import com.Aplication.modelo.Local;
import com.Aplication.modelo.Turno;
import com.Aplication.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository; // Remove 'static' keyword

    // Crear o actualizar un Local
    public Local create(Local local) {
        return localRepository.save(local);
    }

    // Obtener todos los Locales
    public List<Local> getAllLocal() {
        return localRepository.findAll();
    }

    // Obtener Local por ID
    public Optional<Local> findById(int id) {
        return localRepository.findById((long) id);
    }

    // Eliminar un Local por su ID
    public void deleteLocal(Local local) {
        localRepository.delete(local);
    }

    public Local updateLocal(Long id, Local updateLocal) {
        return localRepository.findById(id).map(local -> {
            local.setIdlocal(updateLocal.getIdlocal());
            local.setNombre(updateLocal.getNombre());
            local.setTelefono(updateLocal.getTelefono());
            local.setDirrecion(updateLocal.getDirrecion());
            return localRepository.save(local); // Guardar local actualizado
        }).orElseThrow(() -> new RuntimeException("Local no encontrado"));
    }
}