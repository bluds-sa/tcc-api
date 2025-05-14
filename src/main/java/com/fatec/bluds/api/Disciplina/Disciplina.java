package com.fatec.bluds.api.Disciplina;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Disciplina")
@Table(name = "Disciplina")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String nome;

    @Column
    @NotNull
    private String descricao;
}
