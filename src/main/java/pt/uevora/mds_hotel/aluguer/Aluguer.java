package pt.uevora.mds_hotel.aluguer;

import java.time.LocalDate;

public class Aluguer {
    private int precoAluguer;
    private LocalDate tempoDeAluguer;
    private int quartoId, hospedeId;

    public Aluguer(int precoAluguer, LocalDate tempoDeAluguer, int quartoId, int hospedeId) {
        this.quartoId = quartoId;
        this.hospedeId = hospedeId;

        this.setTempoDeAluguer(tempoDeAluguer);
        this.setPrecoAluguer(precoAluguer);
    }

    private void setTempoDeAluguer(LocalDate tempoDeAluguer) {
        if (!tempoDeAluguer.isBefore(LocalDate.now())) {
            this.tempoDeAluguer = tempoDeAluguer;
        } else {
            throw new IllegalArgumentException("Erro: Não podem existir alugueres anteriores à data de hoje.");
        }
    }

    private void setPrecoAluguer(int precoAluguer) {
        if (precoAluguer < 0) {
            throw new IllegalArgumentException("Erro: Preços negativos não são permitidos");
        }

        this.precoAluguer = precoAluguer;
    }

    public int getPrecoAluguer() {
        return precoAluguer;
    }

    public LocalDate getTempoDeAluguer() {
        return tempoDeAluguer;
    }

    public int getHospedeId() {
        return hospedeId;
    }

    public int getQuartoId() {
        return quartoId;
    }
}
