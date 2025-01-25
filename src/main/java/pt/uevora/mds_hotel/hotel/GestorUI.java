package pt.uevora.mds_hotel.hotel;

import pt.uevora.mds_hotel.manutencao.PedidoManutencao;
import pt.uevora.mds_hotel.quartos.Quarto;

public class GestorUI extends FuncionarioUI {

    public GestorUI() {
        super();
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
}
