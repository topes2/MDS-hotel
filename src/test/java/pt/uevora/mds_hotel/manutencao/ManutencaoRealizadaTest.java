package pt.uevora.mds_hotel.manutencao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pt.uevora.mds_hotel.quartos.Quarto;
import pt.uevora.mds_hotel.quartos.TipoDeVista;

public class ManutencaoRealizadaTest {
    private static Quarto quartoUm;
    private static Quarto quartoDois;

    private static PedidoManutencao pedidoManutencaoUm;
    private static PedidoManutencao pedidoManutencaoDois;

    private static ManutencaoRealizada pedidoRealizadoUm;
    private static ManutencaoRealizada pedidoRealizadoDois;

    @BeforeAll
    public static void setUpBeforePedidosDeManutencaoTestes() {
        quartoUm = new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
        quartoDois = new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
        
        pedidoManutencaoUm = new PedidoManutencao("A luz da casa de banho não funciona", quartoUm);
        pedidoManutencaoDois = new PedidoManutencao("A luz do quarto não funciona", quartoDois);

        pedidoRealizadoUm = new ManutencaoRealizada("Coloquei uma nova lampada na casa de banho", quartoUm, pedidoManutencaoUm);
        pedidoRealizadoDois = new ManutencaoRealizada("Coloquei uma nova lampada no quarto", quartoDois, pedidoManutencaoDois);
    }

    @Test
    public void testarOIdDoQuartoComOIdRealizadoDeveSerDois() {
        assertEquals(quartoDois.getNumeroDoQuarto(), pedidoRealizadoDois.getNumQuarto());
        assertEquals(2, pedidoRealizadoDois.getNumQuarto());        
    }

    @Test
    public void testarUmaVarieadadeDeManutencoesRealizadasDeIDsDeQuartos() {
        Quarto variosQuartosIguais;
        PedidoManutencao variosPedidosIguais;
        ManutencaoRealizada variosManutencoesRealizadasIguais;

        for(int i = 0; i < 10000; i++){
            variosQuartosIguais = new Quarto(30, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
            variosPedidosIguais = new PedidoManutencao("A agua da cozinha náo funciona", variosQuartosIguais);
            variosManutencoesRealizadasIguais = new ManutencaoRealizada("Troquei os canos, e a agua esta a funcionar novamente", variosQuartosIguais, variosPedidosIguais);

            assertEquals(variosQuartosIguais.getNumeroDoQuarto(), variosManutencoesRealizadasIguais.getNumQuarto());
        }
    }

    @Test
    public void testarADecricaoDoRequisito() {
        assertEquals(pedidoManutencaoUm.getManutencaoReq(), pedidoRealizadoUm.getPedidoDeManutencao());
        assertEquals("A luz da casa de banho não funciona", pedidoRealizadoUm.getPedidoDeManutencao());        
    }

    @Test
    public void testarUmaVarieadadeDeDescricoesDasManutencoesPedidas() {
        Quarto variosQuartosIguais;
        PedidoManutencao variosPedidosIguais;
        ManutencaoRealizada variosManutencoesRealizadasIguais;

        for(int i = 0; i < 10000; i++){
            variosQuartosIguais = new Quarto(30, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
            variosPedidosIguais = new PedidoManutencao("A agua da cozinha náo funciona", variosQuartosIguais);
            variosManutencoesRealizadasIguais = new ManutencaoRealizada("Troquei os canos, e a agua esta a funcionar novamente", variosQuartosIguais, variosPedidosIguais);

            assertEquals(variosPedidosIguais.getManutencaoReq(), variosManutencoesRealizadasIguais.getPedidoDeManutencao());
        }
    }

    @Test
    public void testarADecricaoDaManutencaoRealizada() {
        assertEquals("Coloquei uma nova lampada na casa de banho", pedidoRealizadoUm.getManutencaoRelizada());
    }

    @Test
    public void testarUmaVarieadadeDeDescricoesDasManutencoesRealizadas() {
        Quarto variosQuartosIguais;
        PedidoManutencao variosPedidosIguais;
        ManutencaoRealizada variosManutencoesRealizadasIguais;

        for(int i = 0; i < 10000; i++){
            variosQuartosIguais = new Quarto(30, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
            variosPedidosIguais = new PedidoManutencao("A agua da cozinha náo funciona", variosQuartosIguais);
            variosManutencoesRealizadasIguais = new ManutencaoRealizada("Troquei os canos, e a agua esta a funcionar novamente", variosQuartosIguais, variosPedidosIguais);

            assertEquals("Troquei os canos, e a agua esta a funcionar novamente", variosManutencoesRealizadasIguais.getManutencaoRelizada());
        }
    }

    @Test
    public void testarSeTodosOsIdsDasManutencoesRealizadasoSaoUnicos() {
        Set<Integer> idsUnicos = new HashSet<>();
        Quarto variosQuartosIguais;
        PedidoManutencao variosPedidosIguais;
        ManutencaoRealizada variosManutencoesRealizadasIguais;

        for (int i = 0; i < 10000; i++) {
            variosQuartosIguais = new Quarto(30, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
            variosPedidosIguais = new PedidoManutencao("A agua da cozinha náo funciona", variosQuartosIguais);
            variosManutencoesRealizadasIguais = new ManutencaoRealizada("Troquei os canos, e a agua esta a funcionar novamente", variosQuartosIguais, variosPedidosIguais);

            if (!idsUnicos.add(variosManutencoesRealizadasIguais.getIDManutencaoRealizada())) {
                fail();
            }
        }
    }

    @Test
    public void testarADecricaoNulaDeveDarIllegalArgumentException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> { new ManutencaoRealizada("", quartoDois, pedidoManutencaoDois); });
    }

    @Test
    public void testarUmPedidoQueFoiRealizadoDeveTerComoStatusTrue() {
        assertEquals(true, pedidoManutencaoUm.getStatusPedido());
    }

    @Test
    public void testarNumaVariedadeSeTodosOsPedidosDepoisDeRealizadosTemComoStatusTrueEAntesDeRealizadosComoFalse() {
        Quarto variosQuartosIguais;
        PedidoManutencao variosPedidosIguais;
        
        for(int i = 0; i < 10000; i++){
            variosQuartosIguais = new Quarto(30, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
            variosPedidosIguais = new PedidoManutencao("A agua da cozinha náo funciona", variosQuartosIguais);
            assertEquals(false, variosPedidosIguais.getStatusPedido());

            new ManutencaoRealizada("Troquei os canos, e a agua esta a funcionar novamente", variosQuartosIguais, variosPedidosIguais);

            assertEquals(true, variosPedidosIguais.getStatusPedido());
        }
    }

    @Test
    public void testarEscreverNumPedidoQueJaFoiRealizadoDeveDarIllegalArgumentException() throws IllegalArgumentException{
        assertThrows(IllegalArgumentException.class, () -> { new ManutencaoRealizada("Consertei novamente a luz do quarto, mesmo que não fosse necessario", quartoDois, pedidoManutencaoDois); });
    }

    @Test 
    public void testarUmaVariedadeDeEscritaEmPedidosQueJaForamRealizadosDevemDarIllegalArgumentException() throws IllegalArgumentException {
        for(int i = 0; i < 10000; i++){
            Quarto variosQuartosIguais = new Quarto(30, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
            PedidoManutencao variosPedidosIguais = new PedidoManutencao("A agua da cozinha náo funciona", variosQuartosIguais);
            ManutencaoRealizada variosManutencoesRealizadasIguais = new ManutencaoRealizada("Mudei os canos, e a agua funciona novamente", variosQuartosIguais, variosPedidosIguais);
            
            assertEquals("Mudei os canos, e a agua funciona novamente", variosManutencoesRealizadasIguais.getManutencaoRelizada());
            
            assertThrows(IllegalArgumentException.class, () -> {
                new ManutencaoRealizada("Mudei novamente os canos mesmo nao sendo preciso", variosQuartosIguais, variosPedidosIguais);
            });

            assertEquals(true, variosPedidosIguais.getStatusPedido());
        }
    }

    @Test
    public void testarSeDaParaEscreverUmaManutencaoRealizadaNumPedidoDeManutencaoDeveDarIllegalArgumentException() throws IllegalArgumentException{
        pedidoManutencaoDois.remPedidoReq();

        assertThrows(IllegalArgumentException.class, () -> { new ManutencaoRealizada("Afinal não era mesmo preciso a nova luz do quarto", quartoDois, pedidoManutencaoDois); });
    }

    @Test
    public void testarNumaGrandeVariedadeSeDaParaEscreverUmaManutencaoRealizadaNumPedidoDeManutencaoDeveDarIllegalArgumentException() {
        for(int i = 0; i < 10000; i++){
            Quarto variosQuartosIguais = new Quarto(30, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
            PedidoManutencao variosPedidosIguais = new PedidoManutencao("A agua da cozinha náo funciona", variosQuartosIguais);
            variosPedidosIguais.remPedidoReq();
            
            assertThrows(IllegalArgumentException.class, () -> {
                new ManutencaoRealizada("Afinal não era preciso mesmo consertar a agua da cozinha", variosQuartosIguais, variosPedidosIguais);
            });

            assertEquals(true, variosPedidosIguais.getStatusPedido());
        }
    }
}
