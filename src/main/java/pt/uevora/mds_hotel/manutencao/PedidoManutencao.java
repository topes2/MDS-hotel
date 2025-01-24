package pt.uevora.mds_hotel.manutencao;

import pt.uevora.mds_hotel.quartos.Quarto;

public class PedidoManutencao {
    private static int AuxParaId = 0;

    private final int pedidoID;
    private final int quartoID;
    private String manutencaoRequisitada;

    public PedidoManutencao(String manutencaoRequisitada, Quarto quarto) {
        this.pedidoID = ++AuxParaId;
        this.quartoID = quarto.getNumeroDoQuarto();
        this.manutencaoRequisitada = manutencaoRequisitada;

        this.validarRequisitoDaManutencao(manutencaoRequisitada);
    }

    private void validarRequisitoDaManutencao(String manutencaoRequisitada) {
        if(manutencaoRequisitada.length() == 0) throw new IllegalArgumentException("Erro: Um Pedido de manutencao deve ter pelo menos 1 caracter para fazer o pedido."); 
    }

    public int getNumQuarto() {
        return quartoID;
    }

    public String getManutencaoReq() {
        return manutencaoRequisitada;
    }

    public int getIDManutencaoReq() {
        return pedidoID;
    }

    public void setManutencaoReq(String manutencaoRequisitada) {
        this.validarRequisitoDaManutencao(manutencaoRequisitada);
        this.manutencaoRequisitada = manutencaoRequisitada;
    }
}