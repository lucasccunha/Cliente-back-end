package br.com.lucas.clientes.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "Clientes")
public class Cliente {

    @Id
    private String cnpj;

    @Column(name = "razao_social")
    private String razaoSocial;

    private String usuario;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Status status;
}

