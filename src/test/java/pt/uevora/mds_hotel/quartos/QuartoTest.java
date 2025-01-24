package pt.uevora.mds_hotel.quartos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuartoTest {
    private static Quarto quarto;
    private static Quarto quartoTestarEdicoes;

    @BeforeAll
    public static void setUpBeforeQuartoTest() {
        quarto = new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
        quartoTestarEdicoes = new Quarto(32, 16, TipoDeVista.BEIRA_MAR, true, 10, false);
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

    @Test
    public void testarMudarNumMaxDePessoas() {
        quartoTestarEdicoes.setCapacidadeMaxPessoas(20);
        assertEquals(20, quartoTestarEdicoes.getCapacidadeMaxPessoas());
    }

    @Test
    public void testarMudarNumCasasDeBanho() {
        quartoTestarEdicoes.setNumCasasDeBanho(86);
        assertEquals(86, quartoTestarEdicoes.getNumCasasDeBanho());
    }

    @Test
    public void testarMudarTipoDeVista() {
        quartoTestarEdicoes.setTipoDeVista(TipoDeVista.CITADINA);
        assertEquals(TipoDeVista.CITADINA, quartoTestarEdicoes.getTipoDeVista());
    }

    @Test
    public void testarMudarBooleanoVaranda() {
        quartoTestarEdicoes.setVaranda(true);
        assertTrue(quartoTestarEdicoes.hasVaranda());
    }

    @Test
    public void testarMudarBooleanoCozinha() {
        quartoTestarEdicoes.setCozinha(false);
        assertFalse(quartoTestarEdicoes.hasCozinha());
    }

    @Test
    public void testarMudarNumDeCamas() {
        quartoTestarEdicoes.setNumDeCamas(41);
        assertEquals(41, quartoTestarEdicoes.getNumDeCamas());
    }

    @Test
    public void testarEditarQuartoComMaxPessoasNegativasOuZeroDeveRetornarIllegalArgumentException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> quartoTestarEdicoes.setCapacidadeMaxPessoas(-30));
    }

    @Test
    public void testarEditarQuartoComNumDeCamasNegativasOuZeroDeveRetornarIllegalArgumentException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> quartoTestarEdicoes.setNumDeCamas(-1));
    }

    @Test
    public void testarEditarQuartoComNumDeCasasDeBanhoNegativasDeveRetornarIllegalArgumentException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> quartoTestarEdicoes.setNumCasasDeBanho(-1));
    }
}
