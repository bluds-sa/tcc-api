package com.fatec.bluds.api.domain.usuario.subclasses.Estudante;

import com.fatec.bluds.api.domain.disciplina.Disciplina;
import com.fatec.bluds.api.domain.usuario.subclasses.Estudante.Enums.AnoEscolar;
import com.fatec.bluds.api.domain.usuario.subclasses.Estudante.Enums.Periodo;
import com.fatec.bluds.api.domain.usuario.model.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Estudante")
@DiscriminatorValue("ESTUDANTE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Estudante extends Usuario {
    @Column(unique = true)
    @NotNull
    private String matricula;

    @Column
    @NotNull
    private Periodo periodo;

    @Column
    @NotNull
    private AnoEscolar anoEscolar;

    @ManyToMany
    @JoinTable(
            name = "estudante_disciplina",
            joinColumns = @JoinColumn(name = "estudante_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private Set<Disciplina> disciplinas = new HashSet<>();
}
