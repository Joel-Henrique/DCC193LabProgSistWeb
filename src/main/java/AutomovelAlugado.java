public class AutomovelAlugado extends AutomovelEstado{
    @Override
    public boolean DisponibilizarAutomovel(Automovel automovel){
        return true;
    }
    @Override
    public boolean MandarAutomovelManutencao(Automovel automovel){
        return true;
    }

}
