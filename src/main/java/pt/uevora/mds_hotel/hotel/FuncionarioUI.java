package pt.uevora.mds_hotel.hotel;

import pt.uevora.mds_hotel.manutencao.ManutencaoRealizada;
import pt.uevora.mds_hotel.manutencao.PedidoManutencao;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioUI extends HospedeUI {
    protected List<ManutencaoRealizada> listaDePedidosRealizados;

    public FuncionarioUI() {
        super();
        this.listaDePedidosRealizados = new ArrayList<>();
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
