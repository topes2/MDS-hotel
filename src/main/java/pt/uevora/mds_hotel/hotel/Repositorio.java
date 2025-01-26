package pt.uevora.mds_hotel.hotel;

import pt.uevora.mds_hotel.aluguer.Aluguer;
import pt.uevora.mds_hotel.manutencao.ManutencaoRealizada;
import pt.uevora.mds_hotel.manutencao.PedidoManutencao;
import pt.uevora.mds_hotel.quartos.Quarto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private List<Quarto> quartos;
    private List<PedidoManutencao> pedidosDeManutencao;
    private List<ManutencaoRealizada> manutencaoRealizada;
    private List<HospedeUI> hospedes;
    private List<FuncionarioUI> funcionarios;
    private List<Aluguer> aluguers;

    public Repositorio() {
        this.quartos = new ArrayList<>();
        this.pedidosDeManutencao = new ArrayList<>();
        this.manutencaoRealizada = new ArrayList<>();
        this.hospedes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
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

    // --- Pedidos de Promoções
    void fazerUmPedidoDePromocao(HospedeUI hospede) {
        hospedes.add(hospede);
    }

    void removerUmPedidoDePromocao(HospedeUI hospede) {
        hospedes.remove(hospede);
    }

    List<HospedeUI> listarPedidosDePromocao() {
        return hospedes;
    }

    // --- Funcionario em serviço
    void adicionarFuncionarioNoSistema(FuncionarioUI funcionario) {
        funcionarios.add(funcionario);
    }

    List<FuncionarioUI> listarFuncionariosNoSistema() {
        return funcionarios;
    }
    
    // --- Alugueres Realizadas
    void adicionarAluguer(Aluguer aluguer) {
        aluguers.add(aluguer);
    }

    List<Aluguer> obterAlugueres() {
        return aluguers;
    }

    List<Aluguer> obterCheckoutsNaoRealizados(LocalDate targetDate) {
        List<Aluguer> checkoutsNaoRealizados = new ArrayList<>();
        for (Aluguer a : aluguers) {
            if (a.getTempoDeAluguer().isAfter(targetDate)) {
                checkoutsNaoRealizados.add(a);
            }
        }

        return checkoutsNaoRealizados;
    }
}
