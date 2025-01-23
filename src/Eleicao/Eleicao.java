package Eleicao;

import Pessoas.Candidato;
import Pessoas.Eleitor;

import java.time.LocalTime;
import java.util.HashMap;

public class Eleicao {
// falta colocar os novos tipos dos eleitores e canditatos no diagrama
    private HashMap<String, Eleitor> eleitores;
    private HashMap<String, Candidato> candidatos;
    private Boolean encerrado;
    private static final LocalTime horarioDeAbertura = LocalTime.of(8,0);
    private static final LocalTime horarioDeFechamento = LocalTime.of(18,0);
    private int votoNulo = 0;
    private int votoBranco = 0;


    public Eleicao(Boolean encerrado) {
        this.encerrado = encerrado;
        verificarHorario();
        candidatos = new HashMap<>();
        eleitores = new HashMap<>();
    }

    public void cadastrarEleitor(Eleitor novoEleitor) {
        this.eleitores.put(novoEleitor.getTituloEleitoral(), novoEleitor);
    }

    public void cadastrarCandidato(Candidato novoCandidato) {
        this.candidatos.put(novoCandidato.getNumero(), novoCandidato);
    }

    public HashMap<String, Eleitor> getEleitores() {
        return eleitores;
    }

    public HashMap<String, Candidato> getCandidatos() {
        return candidatos;
    }

    private void finalizarEleicao() {
        encerrado = true;
    }

    private void abrirEleicao() {
        encerrado = false;
    }

//    private void votar() {
//        Scanner entrada = new Scanner(System.in);
//
//        String voto = entrada.nextLine();
//
//        for (int i = 0; i < candidatos.size(); i++) {
//            Candidato candidato = candidatos.get(i);
//
//            if (voto.equals(candidato.getNumero())) {
//                candidato.receberVoto();
//                break;
//
//            }
//            if (voto.equals("branco")) {
//                votoBranco++;
//                break;
//            }
//            else if (i + 1 == candidatos.size()) {
//                votoNulo++;
//
//            }
//
//        }
//        verificarHorario();
//
//    }

//    public void registrarVoto(String tituloEleitoral) {
//
//        if (!this.encerrado) {
//            for (int i = 0; i < eleitores.size(); i++) {
//                Eleitor eleitor = eleitores.get(i);
//
//                // verificar se o titulo esta na lista de eleitores
//                if (eleitor.getTituloEleitoral().equals(tituloEleitoral)) {
//
//                    if (eleitor.getJaVotou()) {
//                        break;
//                    } else {
//                        System.out.println(eleitor.getNome());
//                        votar();
//                        eleitor.setJaVotou();
//                        System.out.println("Voto contabilizado");
//                    }
//                    break;
//                }
//            }
//        }
//
//    }

    public void addVotoBranco() {
        votoBranco++;
    }

    public void addVotoNulo() {
        votoNulo++;
    }

    public void gerarRelatorio() {
        for (Candidato candidato : candidatos.values()) {
            System.out.printf("%s: %d\n", candidato.getNome(),candidato.getQntVotos());
        }
        System.out.printf("Brancos: %d\n", votoBranco);
        System.out.printf("Nulos: %d\n", votoNulo);
    }

    public void verificarHorario() {
        LocalTime horaAgora = LocalTime.now();

        if (horaAgora.isBefore(horarioDeAbertura) || horaAgora.isAfter(horarioDeFechamento)) {
            finalizarEleicao();
        }

    }

}

