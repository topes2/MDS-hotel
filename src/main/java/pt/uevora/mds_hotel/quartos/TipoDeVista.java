package pt.uevora.mds_hotel.quartos;

public enum TipoDeVista {
    BEIRA_MAR("Beira Mar");

    private final String value;
    private TipoDeVista(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
