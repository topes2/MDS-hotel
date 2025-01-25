package pt.uevora.mds_hotel.manutencao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pt.uevora.mds_hotel.quartos.Quarto;
import pt.uevora.mds_hotel.quartos.TipoDeVista;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class PedidoManutencaoTest {
    private static Quarto quartoUm;
    private static Quarto quartoDois;
    private static Quarto quartoTres;

    private static PedidoManutencao pedidoManutencaoUm;
    private static PedidoManutencao pedidoManutencaoDois;

    @BeforeAll
    public static void setUpBeforePedidosDeManutencaoTestes() {
        quartoUm = new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
        quartoDois = new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
        quartoTres = new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
        
        pedidoManutencaoUm = new PedidoManutencao("A luz da casa de banho não funciona", quartoTres);
        pedidoManutencaoDois = new PedidoManutencao("A luz do quarto não funciona", quartoTres);
    }

    @Test
    public void testarOIDDoQuartoEscolhidoDeveSer3() {
        assertEquals(3, pedidoManutencaoUm.getNumQuarto());
    }

    @Test
    public void testarUmaVarieadadeDe100IDsDeQuartos() {
        Quarto variosQuartosIguais;
        PedidoManutencao variosPedidosIguais;

        for(int i = 0; i < 10000; i++){
            variosQuartosIguais = new Quarto(30, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
            variosPedidosIguais = new PedidoManutencao("A agua da cozinha náo funciona", variosQuartosIguais);

            assertEquals(variosQuartosIguais.getNumeroDoQuarto(), variosPedidosIguais.getNumQuarto());
        }
    }

    @Test
    public void testarALeituraDoPedidoDeveEstarSemLuzNoQuarto() {
        assertEquals("A luz do quarto não funciona", pedidoManutencaoDois.getManutencaoReq());
    }

    @Test
    public void testarUmaVariedadeDeLeiturasDePedidosDeQuartosQuarto() {
        PedidoManutencao variosPedidosIguais;

        for(int i = 0; i < 10000; i++){
            variosPedidosIguais = new PedidoManutencao("A agua da cozinha náo funciona", quartoTres);

            assertEquals("A agua da cozinha náo funciona", variosPedidosIguais.getManutencaoReq());
        }
    }

    @Test
    public void testarSeTodosOsIdsDosPedidoSaoUnicos() {
        Set<Integer> idsUnicos = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            PedidoManutencao variosPedidosIguais = new PedidoManutencao("A janela esta partida", quartoUm);

            if (!idsUnicos.add(variosPedidosIguais.getIDManutencaoReq())) {
                fail();
            }
        }
    }

    @Test
    public void testarUmPedidoDeManutencaoSemNenhumRequisito() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> { new PedidoManutencao("", quartoDois); });
    }

    @Test
    public void testarUmPedidoQueFoiCriadoSemSerRealizadoDeveTerComoStatusFalse() {
        assertEquals(false, pedidoManutencaoUm.getStatusPedido());
    }

    @Test
    public void testarUmaVariedadeDePedidosCriadosTodosElesDevemTerComoStatusFalse() {
        Quarto variosQuartosIguais;
        PedidoManutencao variosPedidosIguais;

        for(int i = 0; i < 10000; i++){
            variosQuartosIguais = new Quarto(30, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
            variosPedidosIguais = new PedidoManutencao("A agua da cozinha náo funciona", variosQuartosIguais);

            assertEquals(false, variosPedidosIguais.getStatusPedido());
        }
    }
}
