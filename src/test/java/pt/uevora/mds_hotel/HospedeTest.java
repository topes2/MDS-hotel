package pt.uevora.mds_hotel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HospedeTest {
    @Test
    public void testarSeNomeDoHospedeEJoao() {
        Hospede h = new Hospede("João", "joao@", "123");
        assertEquals("João", h.getNome());
    }

    @Test
    public void testarSeSenhaE123() {
        Hospede h = new Hospede("João", "joao@", "123");
        assertEquals("123", h.getSenha());
    }

    @Test
    public void testarSeEmail() {
        Hospede h = new Hospede("João", "joao@", "123");
        assertEquals("joao@", h.getEmail());
    }

    @Test
    public void testarSeNomeVazioRetornaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Hospede("", "@", "123"));
    }

    @Test
    public void testarSeSenhaVaziaRetornaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Hospede("Hospede", "@", ""));
    }
}
