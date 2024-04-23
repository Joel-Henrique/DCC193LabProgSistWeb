package br.ufjf.ldvapi.model.entity;

public class AutomovelDisponivel extends AutomovelEstado {

    private AutomovelDisponivel() {};
    private static AutomovelDisponivel instance = new AutomovelDisponivel();
    /*
    public  static br.ufjf.scLab.model.entity.AutomovelDisponivel getInstance(){
        return instance;
    }
    */
    @Override
    public boolean AlugarAutomovel(Automovel automovel){
        return true;
    }
    @Override
    public boolean MandarAutomovelManutencao(Automovel automovel){
        return true;
    }
    @Override
    public String getEstado(){
        return "Disponivel";
    }
}
