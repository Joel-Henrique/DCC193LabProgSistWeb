package br.ufjf.ldvapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Automovel {
    @Id
    @GeneratedValue
    private long id;
    //@manytoOne
    //private curso curso


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
