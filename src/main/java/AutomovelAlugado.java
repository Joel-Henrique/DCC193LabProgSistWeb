public class AutomovelAlugado extends AutomovelEstado{
    private AutomovelAlugado() {};
    private static AutomovelAlugado instance = new AutomovelAlugado();
    /*
    public  static AutomovelAlugado getInstance(){
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
