package pt.uevora.mds_hotel.hotel;

import pt.uevora.mds_hotel.manutencao.ManutencaoRealizada;
import pt.uevora.mds_hotel.manutencao.PedidoManutencao;
import pt.uevora.mds_hotel.quartos.Quarto;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private List<Quarto> quartos;
    private List<PedidoManutencao> pedidosDeManutencao;
    private List<ManutencaoRealizada> manutencaoRealizada;

    public Repositorio() {
        this.quartos = new ArrayList<>();
        this.pedidosDeManutencao = new ArrayList<>();
        this.manutencaoRealizada = new ArrayList<>();
    }

    // --- Quartos
    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public void removerQuarto(Quarto quarto) {
        quartos.remove(quarto);
    }

    public List<Quarto> obterQuartos() {
        return quartos;
    }

    // --- Pedidos
    public void adicionarPedidoDeManutencao(PedidoManutencao pedido) {
        pedidosDeManutencao.add(pedido);
    }

    public void removerPedidoDeManutencao(PedidoManutencao pedido) {
        pedidosDeManutencao.remove(pedido);
    }

    public List<PedidoManutencao> obterPedidosDeManutencao() {
        return pedidosDeManutencao;
    }

    // --- Manutenções Realizadas
    public void adicionarManutencaoRealizada(ManutencaoRealizada manutencao) {
        manutencaoRealizada.add(manutencao);
    }

    public void removerManutencaoRealizada(ManutencaoRealizada manutencao) {
        manutencaoRealizada.remove(manutencao);
    }

    public List<ManutencaoRealizada> obterManutencaoRealizada() {
        return manutencaoRealizada;
    }
}
