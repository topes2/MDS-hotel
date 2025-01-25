package pt.uevora.mds_hotel.hotel;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import pt.uevora.mds_hotel.manutencao.ManutencaoRealizada;
import pt.uevora.mds_hotel.manutencao.PedidoManutencao;
import pt.uevora.mds_hotel.quartos.Quarto;
import pt.uevora.mds_hotel.quartos.TipoDeVista;

public class HospedeUITest {
    private static HospedeUI hospedeUm;
    private static HospedeUI hospedeDois;

    private static Quarto quartoUm;
    private static Quarto quartoDois;

    @BeforeEach
    public void setUpBeforeTestesDeHospedes() {
        hospedeUm = new HospedeUI();
        hospedeDois = new HospedeUI();

        quartoUm = new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
        quartoDois = new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
        }

    @Test
    public void testarSeSemFiltrosDaTodosOsQuartosQueForamCriados() {
        hospedeUm.listaDeQuartos.add(quartoUm);

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
            hospedeUm.listaDeQuartos.add(variosQuartosIguais);
            esperado.add(variosQuartosIguais);
        }

        List<Quarto> resultado = hospedeUm.filtrarPesquisaQuartos(null, null, null, null, null, null);
        assertEquals(esperado, resultado);
    }

    @Test
    public void testarComFiltrosDeveEncontrarOUnicoQuartoColocado() {
        hospedeUm.listaDeQuartos.add(quartoUm);

        List<Quarto> esperado = List.of(quartoUm);
        List<Quarto> resultado = hospedeUm.filtrarPesquisaQuartos(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);

        assertEquals(esperado, resultado);
    }

    @Test
    public void testarComFiltrosInadequadosNaoDeveEncontrarNenhum() {
        hospedeUm.listaDeQuartos.add(quartoUm);

        List<Quarto> esperado = new ArrayList<>();
        List<Quarto> resultado = hospedeUm.filtrarPesquisaQuartos(3200, 1600, TipoDeVista.BEIRA_MAR, false, 10, false);

        assertEquals(esperado, resultado);
    }

    @Test
    public void testarUmaVariadaDeQuartosComUmUnicoFiltrosAdequados() {
        hospedeUm.listaDeQuartos.add(quartoUm);

        List<Quarto> esperado = List.of(quartoUm);
        Quarto variosQuartosIguais;

        for(int i = 0; i < 10000; i++){
            variosQuartosIguais = new Quarto(3000, 16, TipoDeVista.BEIRA_MAR, false, 20, false);
            hospedeUm.listaDeQuartos.add(variosQuartosIguais);
        }

        List<Quarto> resultado = hospedeUm.filtrarPesquisaQuartos(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
        assertEquals(esperado, resultado);
    }

    @Test
    public void testarUmaVariadaDeQuartosComFiltrosInadequados() {
        hospedeUm.listaDeQuartos.add(quartoUm);

        List<Quarto> esperado = new ArrayList<>();
        Quarto variosQuartosIguais;

        for(int i = 0; i < 10000; i++){
            variosQuartosIguais = new Quarto(3000, 16, TipoDeVista.BEIRA_MAR, false, 20, false);
            hospedeUm.listaDeQuartos.add(variosQuartosIguais);
        }

        List<Quarto> resultado = hospedeUm.filtrarPesquisaQuartos(323, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
        assertEquals(esperado, resultado);
    }

    @Test
    public void testarSeDoisHospedesConseguemEncontrarUmaMesmaListaDeQuartos() {
        hospedeUm.listaDeQuartos.add(quartoUm);
        hospedeDois.listaDeQuartos.add(quartoDois);

        List<Quarto> esperado = List.of(quartoUm, quartoDois);
        List<Quarto> resultado = hospedeUm.filtrarPesquisaQuartos(null, null, null, null, null, null);
        assertEquals(esperado, resultado);
    }
}
