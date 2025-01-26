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

public class GestorUITest {
    private GestorUI gestorUm;
    private GestorUI gestorDois;

    private HospedeUI hospedeUm;

    private static Quarto quartoUm;
    private static Quarto quartoDois;

    @BeforeEach
    public void setUpBeforeGestorTestes() {
        gestorUm = new GestorUI();
        gestorDois = new GestorUI();

        hospedeUm = new HospedeUI();
        
        quartoUm = new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
        quartoDois = new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
    }

    @Test
    public void testarSeConsegueCarregarAClasseGestorUI() {
        GestorUI gestor = new GestorUI();
        assertNotNull(gestor);
    }

    @Test
    public void testarSeDoisOperadoresConseguemFazerACriacaoDeQuartos() {
        gestorUm.adicionarQuarto(quartoUm);
        gestorDois.adicionarQuarto(quartoDois);

        List<Quarto> quartosDoHospede = hospedeUm.obterQuartos(); 

        assertEquals(2, quartosDoHospede.size());
        assertEquals(quartoUm, quartosDoHospede.get(0));
        assertEquals(quartoDois, quartosDoHospede.get(1));
    }

    @Test
    public void testarUmaVariedadeDeDoisGestoresFazerACriacaoDeQuartos() {
        Quarto quartoIgual = new Quarto(10, 10, TipoDeVista.BEIRA_MAR, false, 10, false);

        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                gestorUm.adicionarQuarto(quartoIgual);
            } else {
                gestorDois.adicionarQuarto(quartoIgual);
            }
        }

        List<Quarto> quartosDoHospede = gestorUm.obterQuartos(); 
        assertEquals(1000, quartosDoHospede.size());
    }

    @Test
    public void testarSeUmGestorPodeFazerUmPedidoDeManutencao() {
        PedidoManutencao pedidoManutencaoAtual = new PedidoManutencao("Troquei a lampada", quartoDois);

        gestorUm.adicionarPedido(pedidoManutencaoAtual);

        String pedidos = gestorUm.listarPedidosDeManutencao().toString();
        assertEquals("[Troquei a lampada]", pedidos);
    }

    @Test
    public void testarUmaVariedadeDeOGestorPoderFazerPedidosDeManutencao() {
        Quarto quartoIgual; 
        PedidoManutencao pedidoManutencaoAtual;

        for (int i = 0; i < 1000; i++) {
            quartoIgual = new Quarto(10, 10, TipoDeVista.BEIRA_MAR, false, 10, false);
            pedidoManutencaoAtual = new PedidoManutencao("janela partiu-se", quartoIgual);
            gestorUm.adicionarPedido(pedidoManutencaoAtual);
        }

        List<PedidoManutencao> pedidos = gestorUm.listarPedidosDeManutencao(); 
        assertEquals(1000, pedidos.size());
    }

    @Test
    public void testarSeUmGestorPodeEliminarUmPedidoDeManutencao() {
        PedidoManutencao pedidoManutencaoAtual = new PedidoManutencao("Troquei a lampada", quartoDois);

        gestorUm.adicionarPedido(pedidoManutencaoAtual);
        gestorUm.removerPedido(pedidoManutencaoAtual.getIDManutencaoReq());

        String pedidos = gestorUm.listarPedidosDeManutencao().toString();
        assertEquals("[]", pedidos);
    }

    @Test
    public void testarUmaVariedadeDeOGestorPodeEliminarUmPedidoDeManutencao() {
        Quarto quartoIgual; 
        PedidoManutencao pedidoManutencaoAtual;

        for (int i = 0; i < 1000; i++) {
            quartoIgual = new Quarto(10, 10, TipoDeVista.BEIRA_MAR, false, 10, false);
            pedidoManutencaoAtual = new PedidoManutencao("janela partiu-se", quartoIgual);
            gestorDois.adicionarPedido(pedidoManutencaoAtual);
            gestorUm.removerPedido(i+1);
        }

        String pedidos = gestorUm.listarPedidosDeManutencao().toString();
        assertEquals("[]", pedidos);
    }

    @Test
    public void testarSeUmGestorPodeRealizarUmRegistoDeManutencao() {
        PedidoManutencao pedidoManutencaoAtual = new PedidoManutencao("Troquei a lampada", quartoDois);

        gestorUm.adicionarPedido(pedidoManutencaoAtual);

        ManutencaoRealizada pedidoRealizadoAtual = new ManutencaoRealizada("Troquei a lampada", quartoDois, pedidoManutencaoAtual);
        gestorUm.adicionarRegistoDeManutencao(pedidoRealizadoAtual);

        String feitos = gestorUm.listarManutencaoRealizada().toString();
        assertEquals("[Troquei a lampada]", feitos);
    }

    @Test
    public void testarUmaVariedadePodeRealizarUmRegistoDeManutencao() {
        Quarto quartoIgual; 
        PedidoManutencao pedidoManutencaoAtual;
        ManutencaoRealizada manutencaoRealizada;

        for (int i = 0; i < 1000; i++) {
            quartoIgual = new Quarto(10, 10, TipoDeVista.BEIRA_MAR, false, 10, false);
            pedidoManutencaoAtual = new PedidoManutencao("janela partiu-se", quartoIgual);
            manutencaoRealizada = new ManutencaoRealizada("Novo vidro", quartoIgual, pedidoManutencaoAtual);
            gestorUm.adicionarRegistoDeManutencao(manutencaoRealizada);
        }

        List<ManutencaoRealizada> pedidos = gestorUm.listarManutencaoRealizada(); 
        assertEquals(1000, pedidos.size());
    }
}
