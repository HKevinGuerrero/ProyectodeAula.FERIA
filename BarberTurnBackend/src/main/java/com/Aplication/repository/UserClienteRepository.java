package com.Aplication.repository;

import com.Aplication.modelo.UserCliente;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserClienteRepository extends ListCrudRepository<UserCliente,Long> {

    Optional<UserCliente> findByUsername(final String username);
}
