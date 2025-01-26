package pt.uevora.mds_hotel.aluguer;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AluguerTest {
    @Test
    public void testarSeGeracaoDeIdsGeraTodosOsIdsDiferentes() {
        Set<Integer> idsUnicos = new HashSet<>();

        for(int i = 0; i < 10000; i++){
            Aluguer a = new Aluguer(20, LocalDate.now(), i, i);
            if (!idsUnicos.add(a.getAluguerId())) {
                fail();
            }
        }
    }

    @Test
    public void testarPrecoDoAluguerSer20() {
        Aluguer a = new Aluguer(20, LocalDate.now(), 0, 0);
        assertEquals(20, a.getPrecoAluguer());
    }

    @Test
    public void testarPrecoDoAluguerDeveRetornarRetornarIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Aluguer(-4, LocalDate.of(2004, 1, 22), 0, 0));
    }

    @Test
    public void testarTempoDeAluguerSer22Janeiro2034() {
        Aluguer a = new Aluguer(20, LocalDate.of(2034, 1, 22), 0, 0);
        assertEquals(LocalDate.of(2034, 1, 22), a.getTempoDeAluguer());
    }

    @Test
    public void testarTempoDeAluguerDeveRetornarIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Aluguer(20, LocalDate.of(2004, 1, 22), 0, 0));
    }

    @Test
    public void testarHospedeIdSer32() {
        assertEquals(32, new Aluguer(0, LocalDate.now(), 0, 32).getHospedeId());
    }

    @Test
    public void testarQuartoIdSer75() {
        assertEquals(75, new Aluguer(20, LocalDate.now(), 75, 31).getQuartoId());
    }
}