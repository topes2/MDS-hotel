package pt.uevora.mds_hotel.hotel;

import java.time.LocalDate;
import java.util.List;

import pt.uevora.mds_hotel.aluguer.Aluguer;
import pt.uevora.mds_hotel.manutencao.ManutencaoRealizada;
import pt.uevora.mds_hotel.manutencao.PedidoManutencao;

public class FuncionarioUI extends HospedeUI {
    public FuncionarioUI(Repositorio repositorio) {
        super(repositorio);
        repositorio.adicionarFuncionarioNoSistema(this);
    }

    public void removerPedido(int pedidoID) {
        PedidoManutencao pedidoParaRemover = null;

        for (PedidoManutencao pedido : repositorio.obterPedidosDeManutencao()) {
            if (pedido.getIDManutencaoReq() == pedidoID) {
                pedidoParaRemover = pedido;
                break;
            }
        }

        if (pedidoParaRemover != null) {
            repositorio.removerPedidoDeManutencao(pedidoParaRemover);
        }
    }

    public void adicionarRegistoDeManutencao(ManutencaoRealizada manutencaoRealizada) {
        repositorio.adicionarManutencaoRealizada(manutencaoRealizada);
    }

    public List<PedidoManutencao> listarPedidosDeManutencao() {
        return repositorio.obterPedidosDeManutencao();
    }

    public List<ManutencaoRealizada> listarManutencaoRealizada() {
        return repositorio.obterManutencaoRealizada();
    }

    public void rejeitarPedidoDePromocaoDeFuncionario(HospedeUI hospede) {
        repositorio.removerUmPedidoDePromocao(hospede);
    }

    public FuncionarioUI aceitarPedidoDePromocaoDeFuncionario(HospedeUI hospede) {
        repositorio.removerUmPedidoDePromocao(hospede);

        FuncionarioUI funcionario = new FuncionarioUI(repositorio);

        return funcionario;
    }

    public List<HospedeUI> listarPedidoDePromocaoDeFuncionario() {
        return repositorio.listarPedidosDePromocao();
    }

    public List<FuncionarioUI> listarFuncionarios() {
        return repositorio.listarFuncionariosNoSistema();
    }

    public void adicionarAluguer(Aluguer aluguer) {
        repositorio.adicionarAluguer(aluguer);
    }

    public List<Aluguer> listarAlugueres() {
        return repositorio.obterAlugueres();
    }

    public List<Aluguer> listarCheckoutsNaoRealizados(LocalDate targetDate) {
        return repositorio.obterCheckoutsNaoRealizados(targetDate);
    }

    public List<Aluguer> listarCheckoutsNaoRealizados() {
        return repositorio.obterCheckoutsNaoRealizados(LocalDate.now());
    }

    @Override
    public String toString() {
        return "FuncionarioUI{" +
                "repositorio=" + repositorio +
                '}';
    }
}
