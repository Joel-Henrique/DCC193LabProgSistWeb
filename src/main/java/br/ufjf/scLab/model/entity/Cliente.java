package br.ufjf.scLab.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
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

    @OneToMany(mappedBy = "cliente")
    private List<Locacao> locacoes;
}
