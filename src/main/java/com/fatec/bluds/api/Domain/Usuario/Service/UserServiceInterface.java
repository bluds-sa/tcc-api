package com.fatec.bluds.api.Domain.Usuario.Service;

import com.fatec.bluds.api.Domain.Usuario.Usuario;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface<T extends Usuario> {
    T create(T user);
    Optional<T> findById(Long id);
    Optional<T> findByEmail(String email);
    Optional<T> findByMatricula(String matricula);
    List<T> findAll();
    T update(T user);
    void delete(Long id);

}
