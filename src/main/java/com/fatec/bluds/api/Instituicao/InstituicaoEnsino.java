package com.fatec.bluds.api.Instituicao;

import com.fatec.bluds.api.Instituicao.Endereco.Endereco;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Instituicao")
@Table(name = "Instituicao")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InstituicaoEnsino {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private Endereco endereco;
}
