package br.ufjf.scLab.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Automovel {

    @Id
    private String placa;
    private String cor;
    private int numPortas;
    private String tipoCombustivel;
    private int quilometragem;
    private int ano;
    private String renavam;
    private String chassi;
    private String marca;
    private String modelo;

    @OneToOne
    @JoinColumn(name = "automovel_estado_id")
    private AutomovelEstado estado;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaAutomovel categoria;

    @OneToMany(mappedBy = "automovel")
    private List<Locacao> locacoes;

    public AutomovelEstado getEstado() {
            return this.estado;
    }
}
