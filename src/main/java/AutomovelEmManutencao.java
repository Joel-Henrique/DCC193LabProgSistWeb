public class AutomovelEmManutencao extends AutomovelEstado{
    private AutomovelEmManutencao() {};
    private static AutomovelEmManutencao instance = new AutomovelEmManutencao();
    /*
    public  static AutomovelEmManutencao getInstance(){
        return instance;
    }
    */
    @Override
    public boolean DisponibilizarAutomovel(Automovel automovel){
        return true;
    }
    @Override
    public String getEstado(){
        return "Em Manutencao";
    }
}
