package br.ufjf.scLab.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AutomovelAlugado extends AutomovelEstado{
    private AutomovelAlugado() {};

    private static AutomovelAlugado instance = new AutomovelAlugado();
    /*
    public  static br.ufjf.scLab.model.entity.AutomovelAlugado getInstance(){
        return instance;
    }
    */
    @Override
    public boolean DisponibilizarAutomovel(Automovel automovel){
        return true;
    }
    @Override
    public boolean MandarAutomovelManutencao(Automovel automovel){
        return true;
    }
    @Override
    public String getEstado(){
        return "Alugado";
    }

}
