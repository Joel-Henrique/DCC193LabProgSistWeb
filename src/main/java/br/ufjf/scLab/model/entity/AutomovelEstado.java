package br.ufjf.scLab.model.entity;

public abstract class AutomovelEstado {

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
