package br.ufjf.scLab.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataLocacao;
    private LocalDateTime dataDevolucao;
    private long quilometragemInicial;
    private long quilometragemFinal;
    private double valorLocacao;
    private int finalizada;

    @ManyToOne
    @JoinColumn(name = "automovel_id")
    private Automovel automovel;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

//    public void setAutomovel(Automovel automovel) {
//        this.automovel = automovel;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
//
//    public void setId(Long id) {
//    }
}
