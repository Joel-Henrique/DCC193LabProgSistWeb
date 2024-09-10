package br.ufjf.scLab.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "categoria_automovel", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class CategoriaAutomovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valorMultiplicador;
}
