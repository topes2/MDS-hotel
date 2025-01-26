package pt.uevora.mds_hotel.quartos;

public class Quarto {
    private static int curId = 0;

    private final int numeroDoQuarto;
    private int capacidadeMaxPessoas;
    private int numDeCamas;
    private TipoDeVista tipoDeVista;
    private boolean cozinha;
    private int numCasasDeBanho;
    private boolean varanda;

    public Quarto(int capacidadeMaxPessoas, int numDeCamas, TipoDeVista tipoDeVista, boolean cozinha, int numCasasDeBanho, boolean varanda) {
        this.numeroDoQuarto = ++curId;
        this.capacidadeMaxPessoas = capacidadeMaxPessoas;
        this.numDeCamas = numDeCamas;
        this.tipoDeVista = tipoDeVista;
        this.cozinha = cozinha;
        this.numCasasDeBanho = numCasasDeBanho;
        this.varanda = varanda;

        this.validarNumMaxPessoas(capacidadeMaxPessoas);
        this.validarNumDeCamas(numDeCamas);
        this.validarNumCasasDeBanho(numCasasDeBanho);
    }

    private void validarNumMaxPessoas(int capacidadeMaxPessoas) {
        if (capacidadeMaxPessoas < 1) throw new IllegalArgumentException("Erro: Um quarto tem de pelo menos de conseguir sustentar uma pessoa.");
    }

    private void validarNumDeCamas(int numDeCamas) {
        if (numDeCamas < 1) throw new IllegalArgumentException("Erro: Um quarto tem de ter pelo menos uma cama.");
    }

    private void validarNumCasasDeBanho(int numCasasDeBanho) {
        if (numCasasDeBanho < 0) throw new IllegalArgumentException("Erro: Um quarto tem de ter pelo menos uma casa de banho.");
    }

    public int getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public int getNumCasasDeBanho() {
        return numCasasDeBanho;
    }

    public int getNumDeCamas() {
        return numDeCamas;
    }

    public boolean hasCozinha() {
        return cozinha;
    }

    public int getCapacidadeMaxPessoas() {
        return capacidadeMaxPessoas;
    }

    public TipoDeVista getTipoDeVista() {
        return tipoDeVista;
    }

    public boolean hasVaranda() {
        return varanda;
    }

    public void setCapacidadeMaxPessoas(int capacidadeMaxPessoas) {
        this.validarNumMaxPessoas(capacidadeMaxPessoas);
        this.capacidadeMaxPessoas = capacidadeMaxPessoas;
    }

    public void setVaranda(boolean varanda) {
        this.varanda = varanda;
    }

    public void setCozinha(boolean cozinha) {
        this.cozinha = cozinha;
    }

    public void setNumCasasDeBanho(int numCasasDeBanho) {
        this.validarNumCasasDeBanho(numCasasDeBanho);
        this.numCasasDeBanho = numCasasDeBanho;
    }

    public void setNumDeCamas(int numDeCamas) {
        this.validarNumDeCamas(numDeCamas);
        this.numDeCamas = numDeCamas;
    }

    public void setTipoDeVista(TipoDeVista tipoDeVista) {
        this.tipoDeVista = tipoDeVista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Quarto q = (Quarto) o;
        return this.numeroDoQuarto == q.numeroDoQuarto;
    }
}
