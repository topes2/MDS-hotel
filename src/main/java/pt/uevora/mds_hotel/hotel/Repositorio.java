package pt.uevora.mds_hotel.hotel;

import pt.uevora.mds_hotel.aluguer.Aluguer;
import pt.uevora.mds_hotel.manutencao.ManutencaoRealizada;
import pt.uevora.mds_hotel.manutencao.PedidoManutencao;
import pt.uevora.mds_hotel.quartos.Quarto;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private List<Quarto> quartos;
    private List<PedidoManutencao> pedidosDeManutencao;
    private List<ManutencaoRealizada> manutencaoRealizada;
    private List<Aluguer> aluguers;

    public Repositorio() {
        this.quartos = new ArrayList<>();
        this.pedidosDeManutencao = new ArrayList<>();
        this.manutencaoRealizada = new ArrayList<>();
        this.aluguers = new ArrayList<>();
    }

    // --- Quartos
    void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    void removerQuarto(Quarto quarto) {
        quartos.remove(quarto);
    }

    List<Quarto> obterQuartos() {
        return quartos;
    }

    // --- Pedidos
    void adicionarPedidoDeManutencao(PedidoManutencao pedido) {
        pedidosDeManutencao.add(pedido);
    }

    void removerPedidoDeManutencao(PedidoManutencao pedido) {
        pedidosDeManutencao.remove(pedido);
    }

    List<PedidoManutencao> obterPedidosDeManutencao() {
        return pedidosDeManutencao;
    }

    // --- Manutenções Realizadas
    void adicionarManutencaoRealizada(ManutencaoRealizada manutencao) {
        manutencaoRealizada.add(manutencao);
    }

    void removerManutencaoRealizada(ManutencaoRealizada manutencao) {
        manutencaoRealizada.remove(manutencao);
    }

    List<ManutencaoRealizada> obterManutencaoRealizada() {
        return manutencaoRealizada;
    }

    // --- Alugueres Realizadas
    void adicionarAluguer(Aluguer aluguer) {
        aluguers.add(aluguer);
    }
}
