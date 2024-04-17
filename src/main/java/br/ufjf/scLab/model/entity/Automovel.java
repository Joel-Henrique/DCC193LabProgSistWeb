package br.ufjf.scLab.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Automovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String cor;
    private int numeroPortas;
    private String tipoCombustivel;
    private long Kilometragem;
    private int ano;
    private String renavam;
    private String chassi;
    private String marca;
    private String modelo;
    private AutomovelEstado estado;

}
