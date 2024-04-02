public class AutomovelDisponivel extends AutomovelEstado{
    @Override
    public boolean AlugarAutomovel(Automovel automovel){
        return true;
    }
    @Override
    public boolean MandarAutomovelManutencao(Automovel automovel){
        return true;
    }
}
