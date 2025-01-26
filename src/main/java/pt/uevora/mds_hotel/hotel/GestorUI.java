package pt.uevora.mds_hotel.hotel;

import java.util.List;

import pt.uevora.mds_hotel.quartos.Quarto;
import pt.uevora.mds_hotel.quartos.TipoDeVista;

public class GestorUI extends FuncionarioUI {
    public GestorUI(Repositorio repositorio) {
        super(repositorio);
    }

    public void adicionarQuarto(Quarto quarto) {
        repositorio.adicionarQuarto(quarto);
    }

    public void editarQuarto(int quartoId, Integer capacidadeMaxPessoas, Integer numDeCamas,
                             TipoDeVista tipoDeVista, Boolean cozinha, Integer numCasasDeBanho, Boolean varanda) {

        List<Quarto> quartos = repositorio.obterQuartos();
        for (Quarto curQuarto : quartos) {
            if (curQuarto.getNumeroDoQuarto() == quartoId) {
                if (capacidadeMaxPessoas != null) curQuarto.setCapacidadeMaxPessoas(capacidadeMaxPessoas);
                if (numDeCamas != null) curQuarto.setNumDeCamas(numDeCamas);
                if (tipoDeVista != null) curQuarto.setTipoDeVista(tipoDeVista);
                if (cozinha != null) curQuarto.setCozinha(cozinha);
                if (numCasasDeBanho != null) curQuarto.setNumCasasDeBanho(numCasasDeBanho);
                if (varanda != null) curQuarto.setVaranda(varanda);
                break;
            }
        }
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
