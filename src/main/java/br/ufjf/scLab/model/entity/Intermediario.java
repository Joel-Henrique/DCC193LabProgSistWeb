package br.ufjf.scLab.model.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@DiscriminatorValue("Intermediario")
@Data
public class Intermediario extends CategoriaAutomovel{
}
