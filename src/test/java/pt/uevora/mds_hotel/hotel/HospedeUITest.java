package pt.uevora.mds_hotel.hotel;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import pt.uevora.mds_hotel.manutencao.PedidoManutencao;
import pt.uevora.mds_hotel.quartos.Quarto;
import pt.uevora.mds_hotel.quartos.TipoDeVista;

public class HospedeUITest {
    private static HospedeUI hospedeUm;

    private static GestorUI gestorUm;

    private static Quarto quartoUm;
    private static Quarto quartoDois;

    @BeforeEach
    public void setUpBeforeTestesDeHospedes() {
        Repositorio repositorio = new Repositorio();
        hospedeUm = new HospedeUI(repositorio);

        gestorUm = new GestorUI(repositorio);

        quartoUm = new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
        quartoDois = new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
    }

    @Test
    public void testarSeConsegueCarregarAClasseHospedeUI() {
        Repositorio newRep = new Repositorio();
        HospedeUI hospede = new HospedeUI(newRep);
        assertNotNull(hospede);
    }

    @Test
    public void testarSeSemFiltrosDaTodosOsQuartosQueForamCriados() {
        gestorUm.adicionarQuarto(quartoUm);

        List<Quarto> esperado = List.of(quartoUm);
        List<Quarto> resultado = hospedeUm.filtrarPesquisaQuartos(null, null, null, null, null, null);

        assertEquals(esperado, resultado);
    }

    @Test
    public void testarUmaVariedadeDeQuartosSeSemFiltrosDaTodosOsQuartosQueForamCriados() {
        List<Quarto> esperado = new ArrayList<>();
        Quarto variosQuartosIguais;

        for(int i = 0; i < 10000; i++){
            variosQuartosIguais = new Quarto(30, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
            gestorUm.adicionarQuarto(variosQuartosIguais);
            esperado.add(variosQuartosIguais);
        }

        List<Quarto> resultado = hospedeUm.filtrarPesquisaQuartos(null, null, null, null, null, null);
        assertEquals(esperado, resultado);
    }

    @Test
    public void testarComFiltrosDeveEncontrarOUnicoQuartoColocado() {
        gestorUm.adicionarQuarto(quartoUm);

        List<Quarto> esperado = List.of(quartoUm);
        List<Quarto> resultado = hospedeUm.filtrarPesquisaQuartos(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);

        assertEquals(esperado, resultado);
    }

    @Test
    public void testarComFiltrosInadequadosNaoDeveEncontrarNenhum() {
        gestorUm.adicionarQuarto(quartoUm);

        List<Quarto> esperado = new ArrayList<>();
        List<Quarto> resultado = hospedeUm.filtrarPesquisaQuartos(3200, 1600, TipoDeVista.BEIRA_MAR, false, 10, false);

        assertEquals(esperado, resultado);
    }

    @Test
    public void testarUmaVariadaDeQuartosComUmUnicoFiltrosAdequados() {
        gestorUm.adicionarQuarto(quartoUm);

        List<Quarto> esperado = List.of(quartoUm);
        Quarto variosQuartosIguais;

        for(int i = 0; i < 10000; i++){
            variosQuartosIguais = new Quarto(3000, 16, TipoDeVista.BEIRA_MAR, false, 20, false);
            gestorUm.adicionarQuarto(variosQuartosIguais);
        }

        List<Quarto> resultado = hospedeUm.filtrarPesquisaQuartos(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
        assertEquals(esperado, resultado);
    }

    @Test
    public void testarUmaVariadaDeQuartosComFiltrosInadequados() {
        gestorUm.adicionarQuarto(quartoUm);

        List<Quarto> esperado = new ArrayList<>();
        Quarto variosQuartosIguais;

        for(int i = 0; i < 10000; i++){
            variosQuartosIguais = new Quarto(3000, 16, TipoDeVista.BEIRA_MAR, false, 20, false);
            gestorUm.adicionarQuarto(variosQuartosIguais);
        }

        List<Quarto> resultado = hospedeUm.filtrarPesquisaQuartos(323, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
        assertEquals(esperado, resultado);
    }

    @Test
    public void testarSeUmHospedePodeFazerUmPedidoDeManutencao() {
        Repositorio newRep = new Repositorio();
        PedidoManutencao pedidoManutencaoAtual = new PedidoManutencao("Troquei a lampada", quartoDois);
        FuncionarioUI f = new FuncionarioUI(newRep);
        HospedeUI h = new HospedeUI(newRep);

        h.adicionarPedido(pedidoManutencaoAtual);

        String pedidos = f.listarPedidosDeManutencao().toString();
        assertEquals("[Troquei a lampada]", pedidos);
    }

    @Test
    public void testarUmaVariedadeDeOHospedePoderFazerPedidosDeManutencao() {
        Repositorio newRep = new Repositorio();
        Quarto quartoIgual; 
        PedidoManutencao pedidoManutencaoAtual;
        FuncionarioUI funcionario = new FuncionarioUI(newRep);
        HospedeUI hospede = new HospedeUI(newRep);

        for (int i = 0; i < 1000; i++) {
            quartoIgual = new Quarto(10, 10, TipoDeVista.BEIRA_MAR, false, 10, false);
            pedidoManutencaoAtual = new PedidoManutencao("janela partiu-se", quartoIgual);
            hospede.adicionarPedido(pedidoManutencaoAtual);
        }

        List<PedidoManutencao> pedidos = funcionario.listarPedidosDeManutencao(); 
        assertEquals(1000, pedidos.size());
    }

    @Test
    public void testarSeUmHospedePodeFazerUmPedidoParaVirarFuncionario() {
        Repositorio newRep = new Repositorio();
        HospedeUI hospede = new HospedeUI(newRep);
        FuncionarioUI funcionario = new FuncionarioUI(newRep);

        hospede.askPromocaoFuncionario();

        assertTrue(funcionario.listarPedidoDePromocaoDeFuncionario().contains(hospede));
    }

    @Test
    public void testarUmaVariedadeDePedidosParaPromocaoDeFuncionarioPorParteDoHospede() {
        Repositorio newRep = new Repositorio();
        HospedeUI hospede;
        FuncionarioUI funcionario = new FuncionarioUI(newRep);
        List<HospedeUI> esperado = new ArrayList<>();

        for(int i = 0; i < 1000; i++){
            hospede = new HospedeUI(newRep);
            hospede.askPromocaoFuncionario();
            esperado.add(hospede);
        }

        assertEquals(funcionario.listarPedidoDePromocaoDeFuncionario(), esperado);
    }

    @Test
    public void testarSeUmHospedePodeFazerVariosPedidosDePromocaoDeFuncionario() {
        Repositorio newRep = new Repositorio();
        HospedeUI hospede = new HospedeUI(newRep);
        List<HospedeUI> esperado = new ArrayList<>();

        for(int i = 0; i < 2; i++){
            hospede.askPromocaoFuncionario();
            esperado.add(hospede);
        }

        fail();
    }
}
