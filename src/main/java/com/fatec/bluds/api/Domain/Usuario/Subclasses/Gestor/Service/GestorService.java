package com.fatec.bluds.api.Domain.Usuario.Subclasses.Gestor.Service;

import com.fatec.bluds.api.Domain.Usuario.Subclasses.Gestor.Gestor;
import com.fatec.bluds.api.Domain.Usuario.Subclasses.Gestor.Repository.GestorRepository;
import com.fatec.bluds.api.Infra.Exceptions.Usuario.UsuarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GestorService {

    @Autowired
    private GestorRepository repository;

    public Gestor getGestorById(Long id) {
        Optional<Gestor> optionalGestor = repository.findById(id);

        return optionalGestor.orElseThrow(
                () -> new UsuarioNotFoundException("Gestor com ID " + id + " não foi encontrado")
        );
    }
}
