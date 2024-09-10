package br.ufjf.scLab.model.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@DiscriminatorValue("Luxo")
@Data
public class Luxo extends CategoriaAutomovel{
}
