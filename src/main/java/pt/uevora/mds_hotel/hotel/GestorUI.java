package pt.uevora.mds_hotel.hotel;

import java.util.List;

import pt.uevora.mds_hotel.quartos.Quarto;

public class GestorUI extends FuncionarioUI {
    public GestorUI(Repositorio repositorio) {
        super(repositorio);
    }

    public void adicionarQuarto(Quarto quarto) {
        repositorio.adicionarQuarto(quarto);
    }

    public void removerQuarto(int numeroDoQuarto) {
        Quarto quartoParaRemover = null;

        for (Quarto quarto : repositorio.obterQuartos()) {
            if (quarto.getNumeroDoQuarto() == numeroDoQuarto) {
                quartoParaRemover = quarto;
                break;
            }
        }

        if (quartoParaRemover != null) {
            List<Quarto> quartos = repositorio.obterQuartos();
            quartos.remove(quartoParaRemover);
        }
    }
}
