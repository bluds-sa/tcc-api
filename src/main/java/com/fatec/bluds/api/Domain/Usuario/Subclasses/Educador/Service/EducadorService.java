package com.fatec.bluds.api.Domain.Usuario.Subclasses.Educador.Service;

import com.fatec.bluds.api.Domain.Usuario.Service.UsuarioServiceInterface;
import com.fatec.bluds.api.Domain.Usuario.Subclasses.Educador.Educador;

import java.util.List;
import java.util.Optional;

public class EducadorService implements UsuarioServiceInterface<Educador> {


    @Override
    public Educador create(Educador user) {
        return null;
    }

    @Override
    public Optional<Educador> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Educador> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<Educador> findByMatricula(String matricula) {
        return Optional.empty();
    }

    @Override
    public List<Educador> findAll() {
        return List.of();
    }

    @Override
    public Educador update(Educador user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
