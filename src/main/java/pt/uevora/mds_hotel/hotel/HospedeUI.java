package pt.uevora.mds_hotel.hotel;

import pt.uevora.mds_hotel.manutencao.PedidoManutencao;
import pt.uevora.mds_hotel.quartos.Quarto;
import pt.uevora.mds_hotel.quartos.TipoDeVista;

import java.util.ArrayList;
import java.util.List;

public class HospedeUI {
    protected List<Quarto> listaDeQuartos;
    protected List<PedidoManutencao> listaDePedidosRequisitados;

    public HospedeUI() {
        this.listaDeQuartos = new ArrayList<>();
        this.listaDePedidosRequisitados = new ArrayList<>();
    }

    public List<Quarto> obterQuartos() {
        return Repositorio.obterQuartos();
    }

    public List<Quarto> filtrarPesquisaQuartos(Integer capacidadeMaxPessoas, Integer numDeCamas, TipoDeVista tipoDeVista, Boolean cozinha, Integer numCasasDeBanho, Boolean varanda) {
        List<Quarto> quartosEscolhidos = new ArrayList<>();
    
        for (Quarto quarto : listaDeQuartos) {
            if (capacidadeMaxPessoas != null && quarto.getCapacidadeMaxPessoas() != capacidadeMaxPessoas) continue;
            if (numDeCamas != null && quarto.getNumDeCamas() != numDeCamas) continue;
            if (tipoDeVista != null && quarto.getTipoDeVista() != tipoDeVista) continue;
            if (cozinha != null && quarto.hasCozinha() != cozinha) continue;
            if (numCasasDeBanho != null && quarto.getNumCasasDeBanho() != numCasasDeBanho) continue;
            if (varanda != null && quarto.hasVaranda() != varanda) continue;
    
            quartosEscolhidos.add(quarto);
        }
    
        return quartosEscolhidos;
    }
    
    
    public void adicionarPedido(PedidoManutencao pedido) {
        Repositorio.adicionarPedidoDeManutencao(pedido);
    }    
}
