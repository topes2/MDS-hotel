package pt.uevora.mds_hotel.hotel;

import pt.uevora.mds_hotel.manutencao.ManutencaoRealizada;
import pt.uevora.mds_hotel.manutencao.PedidoManutencao;
import pt.uevora.mds_hotel.quartos.Quarto;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private static List<Quarto> quartos = new ArrayList<>();
    private static List<PedidoManutencao> pedidosDeManutencao = new ArrayList<>();
    private static List<ManutencaoRealizada> manutencaoRealizada = new ArrayList<>();

    // --- Quartos
    public static void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public static void removerQuarto(Quarto quarto) {
        quartos.remove(quarto);
    }

    public static List<Quarto> obterQuartos() {
        return quartos;
    }

    // --- Pedidos
    public static void adicionarPedidoDeManutencao(PedidoManutencao pedido) {
        pedidosDeManutencao.add(pedido);
    }

    public static void removerPedidoDeManutencao(PedidoManutencao pedido) {
        pedidosDeManutencao.remove(pedido);
    }

    public static List<PedidoManutencao> obterPedidosDeManutencao() {
        return pedidosDeManutencao;
    }

    // --- Manutenções Realizadas
    public static void adicionarManutencaoRealizada(ManutencaoRealizada manutencao) {
        manutencaoRealizada.add(manutencao);
    }

    public static void removerManutencaoRealizada(ManutencaoRealizada manutencao) {
        manutencaoRealizada.remove(manutencao);
    }

    public static List<ManutencaoRealizada> obterManutencaoRealizada() {
        return manutencaoRealizada;
    }
}
