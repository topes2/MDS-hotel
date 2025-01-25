package pt.uevora.mds_hotel;

import pt.uevora.mds_hotel.quartos.Quarto;
import pt.uevora.mds_hotel.manutencao.PedidoManutencao;
import pt.uevora.mds_hotel.manutencao.ManutencaoRealizada;

import java.util.ArrayList;
import java.util.List;

public class GerirHotel {
    private List<Quarto> listaDeQuartos;
    private List<PedidoManutencao> listaDePedidosRequisitados;
    private List<ManutencaoRealizada> listaDePedidosRealizados;

    public GerirHotel() {
        this.listaDeQuartos = new ArrayList<>();
        this.listaDePedidosRequisitados = new ArrayList<>();
        this.listaDePedidosRealizados = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        listaDeQuartos.add(quarto);
    }

    public void removerQuarto(int numeroDoQuarto) {
        Quarto quartoParaRemover = null;

        for (Quarto quarto : listaDeQuartos) {
            if (quarto.getNumeroDoQuarto() == numeroDoQuarto) {
                quartoParaRemover = quarto;
                break;
            }
        }

        if (quartoParaRemover != null) {
            listaDeQuartos.remove(quartoParaRemover);
        }
    }

    public void adicionarPedido(PedidoManutencao pedido) {
        listaDePedidosRequisitados.add(pedido);
    }

    public void removerPedido(int pedidoID) {
        PedidoManutencao pedidoParaRemover = null;

        for (PedidoManutencao pedido : listaDePedidosRequisitados) {
            if (pedido.getIDManutencaoReq() == pedidoID) {
                pedidoParaRemover = pedido;
                break;
            }
        }

        if (pedidoParaRemover != null) {
            listaDePedidosRequisitados.remove(pedidoParaRemover);
        }
    }

    public void adicionarRegistoDeManutencao(ManutencaoRealizada manutencaoRealizada) {
        listaDePedidosRealizados.add(manutencaoRealizada);
    }
}
