package br.ufjf.scLab.model.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@DiscriminatorValue("Economico")
@Data
public class Economico extends CategoriaAutomovel{
}
