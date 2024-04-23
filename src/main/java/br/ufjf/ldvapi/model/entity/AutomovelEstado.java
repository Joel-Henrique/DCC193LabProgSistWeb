package br.ufjf.ldvapi.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public abstract class AutomovelEstado {
    @Id
    @GeneratedValue
    private long id;

    public abstract String getEstado();
    public boolean DisponibilizarAutomovel(Automovel automovel){
        return false;
    }
    public boolean AlugarAutomovel(Automovel automovel){
        return false;
    }
    public boolean MandarAutomovelManutencao(Automovel automovel){
        return false;
    }

}
