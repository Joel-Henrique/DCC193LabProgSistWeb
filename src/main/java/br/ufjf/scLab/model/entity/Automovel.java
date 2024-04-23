package br.ufjf.scLab.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
*/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

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

    // @OneToOne(cascade = CascadeType.ALL)
    private AutomovelEstado estado;

}
