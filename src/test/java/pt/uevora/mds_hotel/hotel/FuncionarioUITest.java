package pt.uevora.mds_hotel.hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pt.uevora.mds_hotel.aluguer.Aluguer;
import pt.uevora.mds_hotel.manutencao.ManutencaoRealizada;
import pt.uevora.mds_hotel.manutencao.PedidoManutencao;
import pt.uevora.mds_hotel.quartos.Quarto;
import pt.uevora.mds_hotel.quartos.TipoDeVista;

public class FuncionarioUITest {
    private FuncionarioUI funcionarioUm;

    private static Quarto quartoUm;

    @BeforeEach
    public void setUpBeforeGestorTestes() {
        Repositorio newRep = new Repositorio();
        funcionarioUm = new FuncionarioUI(newRep);

        quartoUm = new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
    }

    @Test
    public void testarSeConsegueCarregarAClasseFuncionarioUI() {
        Repositorio newRep = new Repositorio();
        FuncionarioUI funcionario = new FuncionarioUI(newRep);
        assertNotNull(funcionario);
    }

    @Test
    public void testarSeUmFuncionarioPodeFazerUmPedidoDeManutencao() {
        PedidoManutencao pedidoManutencaoAtual = new PedidoManutencao("Troquei a lampada", quartoUm);

        funcionarioUm.adicionarPedido(pedidoManutencaoAtual);

        String pedidos = funcionarioUm.listarPedidosDeManutencao().toString();
        assertEquals("[Troquei a lampada]", pedidos);
    }

    @Test
    public void testarUmaVariedadeDeOFuncionarioPoderFazerPedidosDeManutencao() {
        Quarto quartoIgual; 
        PedidoManutencao pedidoManutencaoAtual;

        Repositorio newRep = new Repositorio();
        FuncionarioUI funcionarioUI = new FuncionarioUI(newRep);
        for (int i = 0; i < 1000; i++) {
            quartoIgual = new Quarto(10, 10, TipoDeVista.BEIRA_MAR, false, 10, false);
            pedidoManutencaoAtual = new PedidoManutencao("janela partiu-se", quartoIgual);
            funcionarioUI.adicionarPedido(pedidoManutencaoAtual);
        }

        List<PedidoManutencao> pedidos = funcionarioUI.listarPedidosDeManutencao();
        assertEquals(1000, pedidos.size());
    }

    @Test
    public void testarSeUmFuncionarioPodeEliminarUmPedidoDeManutencao() {
        PedidoManutencao pedidoManutencaoAtual = new PedidoManutencao("Troquei a lampada", quartoUm);

        funcionarioUm.adicionarPedido(pedidoManutencaoAtual);
        funcionarioUm.removerPedido(pedidoManutencaoAtual.getIDManutencaoReq());

        String pedidos = funcionarioUm.listarPedidosDeManutencao().toString();
        assertEquals("[]", pedidos);
    }

    @Test
    public void testarUmaVariedadeDeOFuncionarioPodeEliminarUmPedidoDeManutencao() {
        Repositorio newRep = new Repositorio();
        FuncionarioUI funcionarioUI = new FuncionarioUI(newRep);
        for (int i = 0; i < 1000; i++) {
            Quarto quartoIgual = new Quarto(10, 10, TipoDeVista.BEIRA_MAR, false, 10, false);
            PedidoManutencao pedidoManutencaoAtual = new PedidoManutencao("janela partiu-se", quartoIgual);
            funcionarioUI.adicionarPedido(pedidoManutencaoAtual);
            funcionarioUI.removerPedido(pedidoManutencaoAtual.getIDManutencaoReq());
        }

        String pedidos = funcionarioUI.listarPedidosDeManutencao().toString();
        assertEquals("[]", pedidos);
    }

    @Test
    public void testarSeUmFuncionarioPodeRealizarUmRegistoDeManutencao() {
        PedidoManutencao pedidoManutencaoAtual = new PedidoManutencao("Troquei a lampada", quartoUm);

        funcionarioUm.adicionarPedido(pedidoManutencaoAtual);

        ManutencaoRealizada pedidoRealizadoAtual = new ManutencaoRealizada("Troquei a lampada", quartoUm, pedidoManutencaoAtual);
        funcionarioUm.adicionarRegistoDeManutencao(pedidoRealizadoAtual);

        String feitos = funcionarioUm.listarManutencaoRealizada().toString();
        assertEquals("[Troquei a lampada]", feitos);
    }

    @Test
    public void testarUmaVariedadePodeRealizarUmRegistoDeManutencaoFuncionario() {
        Quarto quartoIgual; 
        PedidoManutencao pedidoManutencaoAtual;
        ManutencaoRealizada manutencaoRealizada;

        for (int i = 0; i < 1000; i++) {
            quartoIgual = new Quarto(10, 10, TipoDeVista.BEIRA_MAR, false, 10, false);
            pedidoManutencaoAtual = new PedidoManutencao("janela partiu-se", quartoIgual);
            manutencaoRealizada = new ManutencaoRealizada("Novo vidro", quartoIgual, pedidoManutencaoAtual);
            funcionarioUm.adicionarRegistoDeManutencao(manutencaoRealizada);
        }

        List<ManutencaoRealizada> pedidos = funcionarioUm.listarManutencaoRealizada(); 
        assertEquals(1000, pedidos.size());
    }

    @Test
    public void testarSeUmFuncionarioConsegueAceitarUmPedidoDePromocaoDeUmHospede() {
        Repositorio newRep = new Repositorio();
        HospedeUI hospede = new HospedeUI(newRep);
        FuncionarioUI funcionario = new FuncionarioUI(newRep);

        hospede.askPromocaoFuncionario();

        funcionario.aceitarPedidoDePromocaoDeFuncionario(hospede);

        assertEquals(2, funcionario.listarFuncionarios().size());
    }

    @Test
    public void testarUmaVariedadedeHospedesFazeremTodosPedidosDePromocaoETodosSeremAceites () {
        Repositorio newRep = new Repositorio();
        HospedeUI hospede;
        FuncionarioUI funcionario = new FuncionarioUI(newRep);;

        for (int i = 0; i < 1000; i++) {
            hospede = new HospedeUI(newRep);

            hospede.askPromocaoFuncionario();
            funcionario.aceitarPedidoDePromocaoDeFuncionario(hospede);
        }

        assertEquals(1001, funcionario.listarFuncionarios().size());
    }
    
    public void testarSeUmAluguerFoiAdicionadoAListaDeAlugueres() {
        Aluguer a = new Aluguer(20, LocalDate.now(), 0, 0);

        Repositorio newRep = new Repositorio();
        FuncionarioUI f = new FuncionarioUI(newRep);
        f.adicionarAluguer(a);

        assertEquals(1, f.listarAlugueres().size());
    }

    @Test
    public void testarSeUmaVariedadeDeAlugueresForamAdicionados() {
        Repositorio newRep = new Repositorio();
        FuncionarioUI f = new FuncionarioUI(newRep);

        final int nAlugueres = 10_000;
        for (int i = 0; i < nAlugueres; i++) {
            Aluguer a = new Aluguer(i, LocalDate.now(), i, i);
            f.adicionarAluguer(a);
        }
        assertEquals(nAlugueres, f.listarAlugueres().size());
    }

    @Test
    public void testarSeAluguerAdicionadoTemQuartoComId11() {
        Repositorio newRep = new Repositorio();
        FuncionarioUI f = new FuncionarioUI(newRep);
        f.adicionarAluguer(new Aluguer(90, LocalDate.now(), 11, 23));
        assertEquals(11, f.listarAlugueres().get(0).getQuartoId());
    }

    @Test
    public void testarSeAluguerAdicionadoTemHospedeComId23() {
        Repositorio newRep = new Repositorio();
        FuncionarioUI f = new FuncionarioUI(newRep);
        f.adicionarAluguer(new Aluguer(90, LocalDate.now(), 11, 23));
        assertEquals(23, f.listarAlugueres().get(0).getHospedeId());
    }

    @Test
    public void testarSeVariedadeDeCheckoutsNaoForamRealizados() {
        Repositorio newRep = new Repositorio();
        FuncionarioUI f = new FuncionarioUI(newRep);

        final int nAlugueres = 10_000;
        for (int i = 0; i < nAlugueres; i++) {
            f.adicionarAluguer(new Aluguer(i, LocalDate.now().plusDays(1), i, i));
        }

        List<Aluguer> checkoutsNaoRealizados = f.listarCheckoutsNaoRealizados();
        assertEquals(nAlugueres, checkoutsNaoRealizados.size());
    }

    @Test
    public void testarSeVariedadeDeCheckoutsQueAindaNaoChegaramADataLimite() {
        Repositorio newRep = new Repositorio();
        FuncionarioUI f = new FuncionarioUI(newRep);

        final int nAlugueres = 10_000;
        for (int i = 0; i < nAlugueres; i++) {
            f.adicionarAluguer(new Aluguer(i, LocalDate.now().plusDays(1), i, i));
        }

        List<Aluguer> checkoutsNaoRealizados = f.listarCheckoutsNaoRealizados(LocalDate.now().plusDays(2));
        assertEquals(0, checkoutsNaoRealizados.size());
    }
}
