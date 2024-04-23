package br.ufjf.ldvapi.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public interface CategoriaAutomovel {
    @Id
    @GeneratedValue
    private long id;

}
