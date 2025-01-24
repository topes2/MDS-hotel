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

    public void setManutencaoReq(int manutencaoRequisitada) {
        setManutencaoReq(manutencaoRequisitada);
    }
}