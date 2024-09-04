package br.ufjf.scLab.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private int telefone;
    private String ruaEnd;
    private int numeroEnd;
    private int cep;
    private String email;

    @Getter
    @OneToMany(mappedBy = "cliente")
    private List<Locacao> locacoes;

}
