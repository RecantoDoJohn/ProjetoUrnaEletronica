package Pessoas;

//
public class Partido {
    private String nomePartido;
    private String numeroPartido;
    private int votoDepuEstatual, votoDepuFederal, votoGovernador, votoSenador, votoPresidente;
    private int[] listaVoto = {votoDepuEstatual, votoDepuFederal, votoGovernador, votoSenador, votoPresidente};
    private int[] cadeirasCargo;


    public Partido(String nomePartido, String numeroPartido) {
        this.nomePartido = nomePartido;
        this.numeroPartido = numeroPartido;

        this.cadeirasCargo = new int[2];
    }

    public String getNome() {
        return nomePartido;
    }

    public String getNomePartido() {
        return nomePartido;
    }

    public void receberVoto(int ordemCargo) {
        this.listaVoto[ordemCargo]++;
    }
    public String getNumeroPartido() {
        return this.numeroPartido;
    }

    public int getVotos(int ordemCargo) {
        return this.listaVoto[ordemCargo];
    }

    public void setCadeiras(int i, int quantCadeiras) {
        this.cadeirasCargo[i] = quantCadeiras;
    }

    public int getCadeirasCargo(int i) {
        return cadeirasCargo[i];
    }
}
