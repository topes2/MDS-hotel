package pt.uevora.mds_hotel.hotel;

import java.util.List;

import pt.uevora.mds_hotel.quartos.Quarto;

public class GestorUI extends FuncionarioUI {
    public GestorUI() {
        super();
    }

    public void adicionarQuarto(Quarto quarto) {
        Repositorio.adicionarQuarto(quarto);
    }

    public void removerQuarto(int numeroDoQuarto) {
        Quarto quartoParaRemover = null;

        for (Quarto quarto : Repositorio.obterQuartos()) {
            if (quarto.getNumeroDoQuarto() == numeroDoQuarto) {
                quartoParaRemover = quarto;
                break;
            }
        }

        if (quartoParaRemover != null) {
            List<Quarto> quartos = Repositorio.obterQuartos();
            quartos.remove(quartoParaRemover);
        }
    }
}
