package pt.uevora.mds_hotel.manutencao;

import pt.uevora.mds_hotel.quartos.Quarto;

public class ManutencaoRealizada {
    private static int AuxParaId = 0;

    private final int manutencaoRealizadoID;
    private final int quartoID;
    private final String manutencaoRequisitada;

    private String manutencaoFeita;

    public ManutencaoRealizada(String manutencaoFeita, Quarto quarto, PedidoManutencao pedido) {
        validarManutencaoDuplicadasDeUmUnicoPedido(pedido.getStatusPedido());

        this.manutencaoRealizadoID = ++AuxParaId;
        this.quartoID = quarto.getNumeroDoQuarto();
        this.manutencaoRequisitada = pedido.getManutencaoReq();
        this.manutencaoFeita = manutencaoFeita;
        pedido.setStatusPedido(true);

        validarManutencaoRealizada(manutencaoFeita); 
    }

    private void validarManutencaoRealizada(String manutencaoFeita) {
        if(manutencaoFeita.length() == 0) throw new IllegalArgumentException("Erro: Uma manutencao realizada deve ter pelo menos 1 caracter para fazer o pedido."); 
    }

    private void validarManutencaoDuplicadasDeUmUnicoPedido(Boolean concluido) {
        if(concluido) throw new IllegalArgumentException("Erro: Este pedido já foi realizado."); 
    }

    public String getPedidoDeManutencao(){
        return manutencaoRequisitada;
    }

    public int getNumQuarto() {
        return quartoID;
    }

    public int getIDManutencaoRealizada() {
        return manutencaoRealizadoID;
    }

    public String getManutencaoRelizada(){
        return manutencaoFeita;
    }

    public void setManutencaoRealizada(String manutencaoFeita) {
        this.validarManutencaoRealizada(manutencaoFeita);
        this.manutencaoFeita = manutencaoFeita;
    }

    @Override
    public String toString() {
        return manutencaoFeita; 
    }
}
