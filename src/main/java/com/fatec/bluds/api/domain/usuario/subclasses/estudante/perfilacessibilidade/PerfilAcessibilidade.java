package com.fatec.bluds.api.domain.usuario.subclasses.estudante.perfilacessibilidade;

import com.fatec.bluds.api.domain.usuario.subclasses.estudante.perfilacessibilidade.enums.TipoDeficiencia;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "PerfilAcessibilidade")
@DiscriminatorValue("PERFILACESSIBILIDADE")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class PerfilAcessibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private TipoDeficiencia tipoDeficiencia;

    @Column
    private boolean usaLeitorDeTela;

    @Column
    private boolean modoAltoContraste;

    @Column
    private int tamanhoFonte;

    private boolean talkBack;
}
