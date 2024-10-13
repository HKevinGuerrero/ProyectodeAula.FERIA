package com.Aplication.Services;

import com.Aplication.modelo.Reserva;
import com.Aplication.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // Crear o actualizar una reserva
    public Reserva saveOrUpdate(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Obtener todas las reservas
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    // Obtener reserva por ID
    public Optional<Reserva> findById(int id) {
        return reservaRepository.findById((long) id);
    }

    // Eliminar una reserva por su ID
    public void deleteReserva(Reserva reserva) {
        reservaRepository.delete(reserva);
    }

    // Actualizar una reserva por ID
    public Reserva updateReserva(Long id, Reserva updateReserva) {
        return reservaRepository.findById(id).map(reserva -> {
            reserva.setCliente(updateReserva.getCliente());
            reserva.setId(updateReserva.getId());
            reserva.setEmpleado(updateReserva.getEmpleado());
            reserva.setReservalocal(updateReserva.getReservalocal());
            reserva.setReservaestado(updateReserva.getReservaestado());
            reserva.setReservafecha(updateReserva.getReservafecha());
            return reservaRepository.save(reserva); // Guardar la reserva actualizada
        }).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }
}

