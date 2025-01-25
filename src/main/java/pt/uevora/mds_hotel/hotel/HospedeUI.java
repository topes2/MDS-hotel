package pt.uevora.mds_hotel.hotel;

import pt.uevora.mds_hotel.manutencao.PedidoManutencao;
import pt.uevora.mds_hotel.quartos.Quarto;

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

    public void adicionarPedido(PedidoManutencao pedido) {
        Repositorio.adicionarPedidoDeManutencao(pedido);
    }    
}
