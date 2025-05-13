package com.fatec.bluds.api.Instituicao;

import com.fatec.bluds.api.Instituicao.Endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
