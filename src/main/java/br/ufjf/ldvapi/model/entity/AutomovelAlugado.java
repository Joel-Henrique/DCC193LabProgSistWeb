package br.ufjf.ldvapi.model.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class AutomovelAlugado extends AutomovelEstado {

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
