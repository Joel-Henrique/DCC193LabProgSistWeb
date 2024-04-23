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

public class Cliente {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String ruaEnd;
    private int numeroEnd;
    private String cep;
}
