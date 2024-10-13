/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Aplication.repository;

import com.Aplication.modelo.UserBarbero;
import java.util.Optional;
import org.springframework.data.repository.ListCrudRepository;

/**
 *
 * @author KEVIN-PC
 */
public interface UserBarberoRepository extends ListCrudRepository<UserBarbero,Long> {

    Optional<UserBarbero> findByUsername(final String username);
}
