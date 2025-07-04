package com.fatec.bluds.api.Domain.Instituicao;

import com.fatec.bluds.api.Domain.Instituicao.Endereco.Endereco;
import com.fatec.bluds.api.Domain.Usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Instituicao")
@Table(name = "Instituicao")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InstituicaoEnsino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String nome;

    @Column
    @NotNull
    private String telefone;

    @Column
    @NotNull
    private String email;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "instituicaoEnsino")
    private Set<Usuario> usuarios = new HashSet<>();
}
