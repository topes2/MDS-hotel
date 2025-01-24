package pt.uevora.mds_hotel.quartos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuartoTest {
    private static Quarto quarto;
    private static Quarto terceiroQuarto;

    @BeforeAll
    public static void setUpBeforeQuartoTest() {
        quarto = new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
        new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
        terceiroQuarto = new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
    }

    @Test
    public void testarNumeroDoTerceiroQuartoDeveSerTres() {
        assertEquals(3, terceiroQuarto.getNumeroDoQuarto());
    }

    @Test
    public void testarCriacaoDeQuartoComMaxPessoasNegativasOuZeroDeveRetornarIllegalArgumentException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> new Quarto(0, 1, TipoDeVista.BEIRA_MAR, false, 2, true));
    }

    @Test
    public void testarCriacaoDeQuartoComNumDeCamasNegativasOuZeroDeveRetornarIllegalArgumentException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> new Quarto(1, 0, TipoDeVista.BEIRA_MAR, false, 2, true));
    }

    @Test
    public void testarCriacaoDeQuartoComNumDeCasasDeBanhoNegativasDeveRetornarIllegalArgumentException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> new Quarto(1, 1, TipoDeVista.SERRA, false, -2, true));
    }

    @Test
    public void testarCapacidadeMaxPessoasDeveSer32() {
        assertEquals(32, quarto.getCapacidadeMaxPessoas());
    }

    @Test
    public void testarNumDeCamasDeveSer16() {
        assertEquals(16, quarto.getNumDeCamas());
    }

    @Test
    public void testarTipoDeVistaDeveSerBeiraMar() {
        assertEquals(TipoDeVista.BEIRA_MAR, quarto.getTipoDeVista());
    }

    @Test
    public void testarCozinhaDeveSerVerdadeiro() {
        assertTrue(quarto.hasCozinha());
    }

    @Test
    public void testarNumCasasDeBanhoDeveSer10() {
        assertEquals(10, quarto.getNumCasasDeBanho());
    }

    @Test
    public void testarVarandaDeveSerFalso() {
        assertFalse(quarto.hasVaranda());
    }
}
