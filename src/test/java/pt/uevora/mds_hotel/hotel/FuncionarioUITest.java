package pt.uevora.mds_hotel.hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pt.uevora.mds_hotel.manutencao.ManutencaoRealizada;
import pt.uevora.mds_hotel.manutencao.PedidoManutencao;
import pt.uevora.mds_hotel.quartos.Quarto;
import pt.uevora.mds_hotel.quartos.TipoDeVista;

public class FuncionarioUITest {
    private FuncionarioUI funcionarioUm;

    private static Quarto quartoUm;

    @BeforeEach
    public void setUpBeforeGestorTestes() {
        funcionarioUm = new FuncionarioUI();

        quartoUm = new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
    }

    @Test
    public void testarSeConsegueCarregarAClasseFuncionarioUI() {
        FuncionarioUI funcionario = new FuncionarioUI();
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

        for (int i = 0; i < 1000; i++) {
            quartoIgual = new Quarto(10, 10, TipoDeVista.BEIRA_MAR, false, 10, false);
            pedidoManutencaoAtual = new PedidoManutencao("janela partiu-se", quartoIgual);
            funcionarioUm.adicionarPedido(pedidoManutencaoAtual);
        }

        List<PedidoManutencao> pedidos = funcionarioUm.listarPedidosDeManutencao(); 
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
        Quarto quartoIgual; 
        PedidoManutencao pedidoManutencaoAtual;

        for (int i = 0; i < 1000; i++) {
            quartoIgual = new Quarto(10, 10, TipoDeVista.BEIRA_MAR, false, 10, false);
            pedidoManutencaoAtual = new PedidoManutencao("janela partiu-se", quartoIgual);
            funcionarioUm.adicionarPedido(pedidoManutencaoAtual);
            funcionarioUm.removerPedido(i+1);
        }

        String pedidos = funcionarioUm.listarPedidosDeManutencao().toString();
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
}
