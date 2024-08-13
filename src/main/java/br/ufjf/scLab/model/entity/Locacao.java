package br.ufjf.scLab.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataLocacao;
    private LocalDateTime dataDevolucao;
    private long quilometragemInicial;
    private long quilometragemFinal;
    private double valorLocacao;

    @ManyToOne
    @JoinColumn(name = "automovel_id")
    private Automovel automovel;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // getters and setters
}
