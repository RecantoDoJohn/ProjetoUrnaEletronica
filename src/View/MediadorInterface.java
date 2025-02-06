package View;

import Eleicao.Eleicao;
import View.PresidenteSessao.InterfacePresidente;

public final class MediadorInterface {
    private Eleicao eleicao;
    private InterfacePresidente interfacePresidente;

    public MediadorInterface(Eleicao eleicao) {
        this.eleicao = eleicao;
        this.interfacePresidente = new InterfacePresidente(this.eleicao);
    }

    public void visibilidade(Boolean visivel) {
        this.interfacePresidente.setVisible(visivel);
    }
}
