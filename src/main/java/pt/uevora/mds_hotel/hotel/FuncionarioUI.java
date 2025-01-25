package pt.uevora.mds_hotel.hotel;

import java.util.List;

import pt.uevora.mds_hotel.manutencao.ManutencaoRealizada;
import pt.uevora.mds_hotel.manutencao.PedidoManutencao;

public class FuncionarioUI extends HospedeUI {
    public FuncionarioUI() {
        super();
    }

    public void removerPedido(int pedidoID) {
        PedidoManutencao pedidoParaRemover = null;

        for (PedidoManutencao pedido : Repositorio.obterPedidosDeManutencao()) {
            if (pedido.getIDManutencaoReq() == pedidoID) {
                pedidoParaRemover = pedido;
                break;
            }
        }

        if (pedidoParaRemover != null) {
            Repositorio.removerPedidoDeManutencao(pedidoParaRemover);
        }
    }

    public void adicionarRegistoDeManutencao(ManutencaoRealizada manutencaoRealizada) {
        Repositorio.adicionarManutencaoRealizada(manutencaoRealizada);
    }

    public List<PedidoManutencao> listarPedidosDeManutencao() {
        return Repositorio.obterPedidosDeManutencao();
    }

    public List<ManutencaoRealizada> listarManutencaoRealizada() {
        return Repositorio.obterManutencaoRealizada();
    }
}
